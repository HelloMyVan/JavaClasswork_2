/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaclasswork_2;
import java.io.*;
import java.util.*;
/**
 *
 * @author fsl97
 */
public class JavaClasswork_2 {
    public static void main(String args[]){
		int choose;
		Scanner reader = new Scanner(System.in);
		Class CLASS[] = new Class[10];
		Book BOOK[] = new Book[100];
		int C_num=0,B_num=0;
		do
		{
			System.out.print("课程选择\n1、创建课程\n2、创建教材\n3、为课程选择教材\n4、检查是否操作成功\n0、退出\n");
			choose = reader.nextInt();
			if(choose == 0){
				break;
			}
			if(choose == 1){
				System.out.println("Enetr class name:");
				String ClassName;
				ClassName = reader.next();
				Class newClass = new Class();
				newClass.SetName(ClassName);
				CLASS[C_num]=newClass;
				C_num++;
			}
			else if(choose  == 2){
				System.out.println("Enetr book name:");
				String BookName;
				BookName = reader.next();
				Book newBook = new Book();
				newBook.SetName(BookName);
				BOOK[B_num]=newBook;
				B_num++;
			}
			else if(choose == 3){
				for(int m=0;m<10;m++){
					if(CLASS[m] == null){System.out.println("就这些了。");break;}
					System.out.print("目前课程有：");
                                        System.out.print((m+1)+"、"+CLASS[m].GetName());
				}
				for(int n=0;n<100;n++){
					if(BOOK[n] == null){System.out.println("就这些了。");break;}
					System.out.print("目前教材有：");
                                        System.out.print((n+1) +"、"+BOOK[n].GetName());
				}
                                System.out.println("输入选择的课程：");
                                int x,y;
                                x=reader.nextInt();
                                System.out.println("输入选择的教材（0为结束输入）:");
                                y=reader.nextInt();
                                while(y != 0){
                                    Choose choose_2 = new Choose();
                                    choose_2.SetBook(BOOK[y-1], CLASS[x-1]);
                                    System.out.println("选择完成！");
                                    y=reader.nextInt();
                                }
			}
                        else if(choose == 4){
                            Test TEST = new Test();
                            TEST.test();
                        }
			else{
				System.out.println("请输入正确选项！");
			}
		}
		while(choose!=0);
	}

}

class Book{
	private String name;
	public String GetName(){
		return name;
	}
	public void SetName(String Name){
		name=Name;
	}
}

class Class{
	private String name;
	public String ClassBook[] = new String[9];
	public String GetName(){
		return name;
	}
	public void SetName(String Name){
		name=Name;
	}
	public void GetBook(){
		for(int i=0;i<9;i++){
			if(ClassBook[i]!=null){
				System.out.println(ClassBook[i]);
			}
		}
	}
}

class Choose{
	public void SetBook(Book MyBook,Class MyClass){
		for(int i=0;i<9;i++){
			if(MyClass.ClassBook[i]==null){
				MyClass.ClassBook[i] = MyBook.GetName();
				break;
				}
			else{}
		}
	}
}

class Test{
    public void test(){
         System.out.println("现在进行功能测试");
         Book ComputerScience = new Book();
         ComputerScience.SetName("ComputerScience");
         System.out.println("教材名称："+ComputerScience.GetName());
         if(ComputerScience.GetName() == "ComputerScience"){
             System.out.println("教材名称设置无障碍.");
         }
         else{
             System.out.println("教材名称设置故障.");
         }
         Class CS = new Class();
         CS.SetName("ComputerScience");
         System.out.println("教材名称："+CS.GetName());
         if(CS.GetName() == "ComputerScience"){
             System.out.println("课程名称设置无障碍.");
         }
         else{
             System.out.println("课程名称设置故障.");
         }
         Choose CS_Choose = new Choose();
         CS_Choose.SetBook(ComputerScience, CS);
         if(CS.GetName() == ComputerScience.GetName()){
             System.out.println("课程选择设置无障碍.");
         }
         else{
             System.out.println("课程选择设置故障.");
         }
    }
}