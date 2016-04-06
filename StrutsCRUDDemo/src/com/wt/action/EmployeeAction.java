package com.wt.action;

import java.util.Map;

import org.apache.catalina.core.ApplicationContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.wt.dao.Dao;
import com.wt.entity.Employee;

public class EmployeeAction implements RequestAware, ModelDriven<Employee>, Preparable{
	
	private Dao dao = new Dao();
	
	private Map<String, Object> requesetMap;
	
	// 1. 需要在当前的 EmployeeAction 定义 employeeId 属性
	// 用以接受请求参数
	private Integer employeeId;

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
	// 执行删除操作
	public String delete() {
		
//		dao.delete(employeeId);
		
		dao.delete(employeeId);
		
		// 返回结果的类型应该为： redirectAction
		// 也可以是 chain： 实际上 chain 是没有必要的，因为不需要在下一个 Action 中保留 当前的 Action 的状态
		// 还有，若使用 chain，则到达目标页面后，地址栏显示的依然是 删除 的那个连接，刷新时会有重复的提交
		// 所以使用 redirectAction
		return "success";
	}
	
	// 解决代码冗余的办法
	private Employee employee;
//	private String firstName;
//	private String lastName;
//	private String email;
//	
//	public Integer getEmployeeId() {
//		return employeeId;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}

	// 执行添加操作
	public String save(){
		
		// 1. 获取请求参数,通过定义属性的方式
		
		// 2. 调用 Dao 的save方法
//		Employee employee = new Employee(null, firstName, lastName, email);
//		dao.save(employee);
		dao.save(employee);
		
		// 3. 通过 redirectAction 的方式响应结果给 emp-list

		// 以下用于测试时使用, 证明此时的 employee 为 值栈栈顶的对象
		System.out.println("employee : " + employee.hashCode());
		System.out.println("此时值栈栈顶的对象 ：" + ActionContext.getContext().getValueStack().peek().hashCode());
		
		return "success";
	}
	
	// 为 save 方法进行前期的准备，准备一个新的 employee 对象，之后进行 employee 的添加操作
	public void prepareSave() {
		employee = new Employee();
	}

	// 显示所有的employee
	public String list(){
		
		requesetMap.put("emps", dao.geteEmployees());
		
		return "list";
	}
	
	
	// 以下回显编辑 employee 的操作
	public String edit(){
		
		// 1. 获取传入的 employeeId : employee.getEmployeeId()
		
		
		// 2. 根据 employeeId 获取 employee 对象
		
//		Employee emp = dao.get(employeeId);
		
		// 3. 把栈顶对象的属性装配好 : 此时栈顶对象为 employee
		// 目前的 employee 对象只有 employeeId 属性，其他属性为 null
		
		/**
		 *  Struts2 表单回显时：从值栈栈顶开始查找匹配的属性就添加到 value 属性中
		 *  
		 */
		
		// 代码冗余的部分，直接放入栈顶即可
//		employee.setFirstName(emp.getFirstName());
//		employee.setLastName(emp.getLastName());
//		employee.setEmail(emp.getEmail());
		
		// 不能够进行表单的回显，因为此时经过重新赋值的 employee 对象已经不再是栈顶对象了
//		employee =  dao.get(employee.getEmployeeId());
		
		// 手动的把从数据库中获取的 employee 对象放到值栈的栈顶
		// 但此时值栈栈顶及第二个对象均为 employee 对象，不够完美
//		ActionContext.getContext().getValueStack().push(emp);
		
		
		return "edit";
	}
	
	// 为 edit 方法获取需要修改的 employee
	public void prepareEdit() {
		employee = dao.get(employeeId);
	}
	
	
	// 以下为修改 employee 的操作
	public String update(){
		
		dao.update(employee);
		
		return "success";
	}
	
	// 为 update 准备一个新的 employee 对象
	public void prepareUpdate() {
		employee = new Employee();
	}
	

	@Override
	public void setRequest(Map<String, Object> request) {
		
		this.requesetMap = request;
		
	}

	// 利用实现 ModelDriven<Employee>解决代码冗余的问题
	// 将 employee 对象放到栈顶
	@Override
	public Employee getModel() {
		// 判断是 Create 还是  Edit
		// 若为 Create，则  employee =  new Employee()
		// 若为 Edit，则从数据库中获取，employee = dao.get(employeeId)
		// 判定标准为 是否有 employeeId 这个请求参数
		// 若有该参数，则视为 Edit；若没有该参数，则视为 Create
		// 若通过 employeeId 来判断，则需要在 ModelDriven 拦截器之前先执行一个 params 拦截器
		// 而这可以通过使用 paramsPrepareParams 拦截器实现
		// 意味着需要在 struts.xml 文件中配置使用 paramsPrepareParams ， 作为默认的拦截器栈
//		
//		if(employeeId == null)
//			employee = new Employee();
//		else
//			employee = dao.get(employeeId);
		
		return employee;
	}

	/**
	 * 	prepare() 方法的主要作用： 为 getModel() 方法准备 model 的
	 * 
	 */
	@Override
	public void prepare() throws Exception {

		System.out.println("prepare。。。。。。。");
		
	}
	
}
