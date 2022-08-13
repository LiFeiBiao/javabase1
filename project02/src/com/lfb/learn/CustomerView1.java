package com.lfb.learn;

public class CustomerView1 {
    private CustomerList1 customers = new CustomerList1(10);

    public CustomerView1() {
        Customer1 cust = new Customer1("张三", '男', 30, "010-56253825",
                "abc@email.com");
        customers.addCustomer(cust);
    }

    public void enterMainMenu() {
        boolean loopFlag = true;
        do {
            System.out
                    .println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");

            char key = CMUtility1.readMenuSelection();
            System.out.println();
            switch (key) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("确认是否退出(Y/N)：");
                    char yn = CMUtility1.readConfirmSelection();
                    if (yn == 'Y')
                        loopFlag = false;
                    break;
            }
        } while (loopFlag);
    }

    private void addNewCustomer() {
        System.out.println("---------------------添加客户---------------------");
        System.out.print("姓名：");
        String name = CMUtility1.readString(4);
        System.out.print("性别：");
        char gender = CMUtility1.readChar();
        System.out.print("年龄：");
        int age = CMUtility1.readInt();
        System.out.print("电话：");
        String phone = CMUtility1.readString(15);
        System.out.print("邮箱：");
        String email = CMUtility1.readString(15);

        Customer1 cust = new Customer1(name, gender, age, phone, email);
        boolean flag = customers.addCustomer(cust);
        if (flag) {
            System.out
                    .println("---------------------添加完成---------------------");
        } else {
            System.out.println("----------------记录已满,无法添加-----------------");
        }
    }

    private void modifyCustomer() {
        System.out.println("---------------------修改客户---------------------");

        int index = 0;
        Customer1 cust = null;
        for (;;) {
            System.out.print("请选择待修改客户编号(-1退出)：");
            index = CMUtility1.readInt();
            if (index == -1) {
                return;
            }

            cust = customers.getCustomer(index - 1);
            if (cust == null) {
                System.out.println("无法找到指定客户！");
            } else
                break;
        }

        System.out.print("姓名(" + cust.getName() + ")：");
        String name = CMUtility1.readString(4, cust.getName());

        System.out.print("性别(" + cust.getGender() + ")：");
        char gender = CMUtility1.readChar(cust.getGender());

        System.out.print("年龄(" + cust.getAge() + ")：");
        int age = CMUtility1.readInt(cust.getAge());

        System.out.print("电话(" + cust.getPhone() + ")：");
        String phone = CMUtility1.readString(15, cust.getPhone());

        System.out.print("邮箱(" + cust.getEmail() + ")：");
        String email = CMUtility1.readString(15, cust.getEmail());

        cust = new Customer1(name, gender, age, phone, email);

        boolean flag = customers.replaceCustomer(index - 1, cust);
        if (flag) {
            System.out
                    .println("---------------------修改完成---------------------");
        } else {
            System.out.println("----------无法找到指定客户,修改失败--------------");
        }
    }

    private void deleteCustomer() {
        System.out.println("---------------------删除客户---------------------");

        int index = 0;
        Customer1 cust = null;
        for (;;) {
            System.out.print("请选择待删除客户编号(-1退出)：");
            index = CMUtility1.readInt();
            if (index == -1) {
                return;
            }

            cust = customers.getCustomer(index - 1);
            if (cust == null) {
                System.out.println("无法找到指定客户！");
            } else
                break;
        }

        System.out.print("确认是否删除(Y/N)：");
        char yn = CMUtility1.readConfirmSelection();
        if (yn == 'N')
            return;

        boolean flag = customers.deleteCustomer(index - 1);
        if (flag) {
            System.out
                    .println("---------------------删除完成---------------------");
        } else {
            System.out.println("----------无法找到指定客户,删除失败--------------");
        }
    }

    private void listAllCustomers() {
        System.out.println("---------------------------客户列表---------------------------");
        Customer1[] custs = customers.getAllCustomers();
        if (custs.length == 0) {
            System.out.println("没有客户记录！");
        } else {
            System.out.println("编号\t姓名\t性别\t年龄\t\t电话\t\t邮箱");
            for (int i = 0; i < custs.length; i++) {
//            System.out.println(i + 1 + "\t" + custs[i].getName() + "\t" + custs[i].getGender() + "\t" + custs[i].getAge() + "\t\t" + custs[i].getPhone() + "\t" + custs[i].getEmail());
                System.out.println((i+1) + "\t" + custs[i].getDetails());
            }
        }

        System.out.println("-------------------------客户列表完成-------------------------");
    }

    public static void main(String[] args) {
        CustomerView1 cView = new CustomerView1();
        cView.enterMainMenu();
    }
}
