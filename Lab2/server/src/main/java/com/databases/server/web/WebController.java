package com.databases.server.web;

import com.databases.server.entities.*;
import com.databases.server.exceptions.UserAlreadyExistsException;
import com.databases.server.services.*;
import com.databases.server.services.SaleService;
import com.databases.server.web.pojo.TableInfo;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class WebController {

  private UserService userService;
  private CategoryService categoryService;
  private CheckService checkService;
  private CustomerCardService customerCardService;
  private EmployeeService employeeService;
  private ProductService productService;
  private SaleService saleService;
  private StoreProductService storeProductService;

  public WebController(UserService userService, CategoryService categoryService, CheckService checkService, CustomerCardService customerCardService, EmployeeService employeeService, ProductService productService, SaleService saleService, StoreProductService storeProductService) {
    this.userService = userService;
    this.categoryService = categoryService;
    this.checkService = checkService;
    this.customerCardService = customerCardService;
    this.employeeService = employeeService;
    this.productService = productService;
    this.saleService = saleService;
    this.storeProductService = storeProductService;
  }

  @GetMapping("/tables")
  List<String> tables(@RequestParam String id) {
    List<String> tables = new ArrayList<>();
    System.out.println(userService.getRole(id));
    tables.add("Category");
    tables.add("Check");
    tables.add("CustomerCard");
    tables.add("Employee");
    tables.add("Product");
    tables.add("Sale");
    tables.add("StoreProduct");
    return tables;
  }

  @GetMapping("/insert")
  List<String> insert(@RequestParam String id) {
    List<String> tables = new ArrayList<>();
    System.out.println(userService.getRole(id));
    tables.add("Category");
    tables.add("Check");
    tables.add("CustomerCard");
    tables.add("Employee");
    tables.add("Product");
    tables.add("Sale");
    tables.add("StoreProduct");
    return tables;
  }

  @GetMapping("/addtables")
  List<String> addTables(@RequestParam String id) {
    List<String> tables = new ArrayList<>();
    System.out.println(userService.getRole(id));
    tables.add("");
    tables.add("");
    tables.add("");
    tables.add("");
    tables.add("");
    tables.add("");
    tables.add("");
    return tables;
  }

  @GetMapping("/category")
  TableInfo<Category> category() {
    List<String> columns = new ArrayList<String>();
    columns.add("categoryNumber");
    columns.add("categoryName");
    return new TableInfo<Category>("Category", columns, this.categoryService.findAll());
  }

  @GetMapping("/check")
  TableInfo<Check> check() {
    List<String> columns = new ArrayList<String>();
    columns.add("checkNumber");
    columns.add("printDate");
    columns.add("sumTotal");
    columns.add("vat");
    columns.add("customerCard");
    columns.add("employee");
    return new TableInfo<Check>("Check", columns, this.checkService.findAll());
  }

  @GetMapping("/customercard")
  TableInfo<CustomerCard> customerCard() {
    List<String> columns = new ArrayList<String>();
    columns.add("cardNumber");
    columns.add("custName");
    columns.add("custSurname");
    columns.add("custPatronymic");
    columns.add("phoneNumber");
    columns.add("city");
    columns.add("street");
    columns.add("zipCode");
    columns.add("percent");

    System.out.println(this.categoryService.findAll());
    return new TableInfo<CustomerCard>("CustomerCard", columns, this.customerCardService.findAll());
  }


  @GetMapping("/employee")
  TableInfo<Employee> employee() {
    List<String> columns = new ArrayList<String>();
    columns.add("idEmployee");
    columns.add("emplSurname");
    columns.add("emplName");
    columns.add("emplPatronymic");
    columns.add("role");
    columns.add("salary");
    columns.add("dateOfBirth");
    columns.add("dateOfStart");
    columns.add("phoneNumber");
    columns.add("city");
    columns.add("street");
    columns.add("zipCode");
    return new TableInfo<Employee>("Employee", columns, this.employeeService.findAll());
  }

  @GetMapping("/product")
  TableInfo<Product> product() {
    List<String> columns = new ArrayList<String>();
    columns.add("idProduct");
    columns.add("productName");
    columns.add("characteristics");
    columns.add("category");
    return new TableInfo<Product>("Product", columns, this.productService.findAll());
  }

  @GetMapping("/sale")
  TableInfo<SaleDto> sale() {
    List<String> columns = new ArrayList<String>();
    columns.add("upc");
    columns.add("checkNumber");
    columns.add("productNumber");
    columns.add("sellingPrice");
    List<Sale> sales = this.saleService.findAll();
    List<SaleDto> saleDtos = new ArrayList<>();
    for (Sale s : sales) {
      saleDtos.add(new SaleDto(s));
    }
    return new TableInfo<SaleDto>("Sale", columns, saleDtos);
  }

  @GetMapping("/storeproduct")
  TableInfo<StoreProduct> storeProduct() {
    List<String> columns = new ArrayList<String>();
    columns.add("upc");
    columns.add("sellingPrice");
    columns.add("productsNumber");
    columns.add("promotionalProduct");
    columns.add("product");
    columns.add("storeProductChild");

    return new TableInfo<StoreProduct>("StoreProduct", columns, this.storeProductService.findAll());
  }

  @ResponseBody
  @PostMapping("/insert/category")
  public boolean insertCategory(@RequestBody CategoryHolderDelete holder) {
    if ("Manager".equals(userService.getRole(holder.getId().toString()))) {
      categoryService.insert(holder.getSource().getCategoryNumber(), holder.getSource().getCategoryName());
      return true;
    }
    return false;
  }

  static class CategoryHolderDelete {
    private Long id;
    private Category source;

    public void setId(Long id) {
      this.id = id;
    }

    public void setSource(Category source) {
      this.source = source;
    }

    public Long getId() {
      return id;
    }

    public Category getSource() {
      return source;
    }
  }

  @ResponseBody
  @PostMapping("/delete/category")
  public boolean deleteCategory(@RequestBody CategoryHolderDelete holder) {
    if ("Manager".equals(userService.getRole(holder.getId().toString()))) {
      categoryService.delete(holder.getSource().getCategoryNumber());
      return true;
    }
    return false;
  }

  static class CategoryHolderUpdate {
    private Long id;
    private Category source;
    private Category destin;

    public void setId(Long id) {
      this.id = id;
    }

    public void setSource(Category source) {
      this.source = source;
    }

    public void setDestin(Category destin) {
      this.destin = destin;
    }

    public Long getId() {
      return id;
    }

    public Category getSource() {
      return source;
    }

    public Category getDestin() {
      return destin;
    }
  }

  @ResponseBody
  @PostMapping("/update/category")
  public boolean updateCategory(@RequestBody CategoryHolderUpdate holder) {
    if ("Manager".equals(userService.getRole(holder.getId().toString()))) {
      categoryService.update(holder.source.getCategoryNumber(), holder.destin.getCategoryName());
      return true;
    }
    return false;
  }

  @ResponseBody
  @PostMapping("/user/registration")
  public boolean userRegistration(@RequestBody User user) {
    if (userService.findUserById(user.getUserId()) != null) {
      throw new UserAlreadyExistsException("User with such username already exists");
    }
    userService.save(user);
    return true;
  }

  @ResponseBody
  @GetMapping("/user/role")
  public String userRole(@RequestBody String id) {
    System.out.println(id);
    if (userService.findUserById(id) == null) {
      throw new InvalidParameterException("No User with such id");
    }
    return userService.getRole(id);
  }
}
