package cse;

import java.util.*;

public class Student
{
     static String Univ_name = "ABCD University";
 
     int roll_no[] = new int[1000];
     String name[] = new String[100];
     int marks_java[] = new int[100];
     int marks_co[] = new int[100];
     int marks_dm[] = new int[100];
     double p[] = new double[100];
     char g[] = new char[100];
 
     int input(int n)
     {
 
         Scanner sc = new Scanner(System.in);
         for(int i =0;i<n;i++)
         {
              System.out.println("Enter the roll no. of student_"+(i+1)+":");
              roll_no[i]=sc.nextInt();
              System.out.println("Enter the name of student_"+(i+1)+":");
              name[i]= sc.next();
              System.out.println("Enter the marks in java of student_"+(i+1)+":");
              marks_java[i]= sc.nextInt();
              System.out.println("Enter the marks in co of student_"+(i+1)+":");
              marks_co[i]= sc.nextInt();
              System.out.println("Enter the marks in dm of student_"+(i+1)+":");
              marks_dm[i]= sc.nextInt();
         }
         System.out.println("Enter 1 if you want to search and view the data of a particular student otherwise enter 0 : ");
         int ch = sc.nextInt();
         if(ch==1)
         {
              System.out.println("Enter the roll no. of the student whose data you want to search:");
              int m = sc.nextInt();
              Search(n,m);
         }
         sc.close();
         return n;
     }

     int Search(int n,int m)
     {
          Scanner sc =new Scanner(System.in);
          int f=0;
          for(int i=0;i<n;i++)
          {
              if(m==roll_no[i])
              {
                  f=i;
                  edisplay(n,m);
                  break;
              }
          }
          sc.close();
          return f;
      }
 
      int Calc_grade(int n)
      {
 
           Sort(n);
           char c=0;
           int total =0;

           for(int i=0;i<n;i++)
           {
                p[i] = (((marks_java[i]+marks_co[i]+marks_dm[i]) / 300.0) * 100);
                if(p[i]>=80)
                {
                     g[i]='A';
                }
                else if(p[i]>=70 && p[i]<=79)
                {
                     g[i]='B';
                }
                else if(p[i]>=60 && p[i]<=69)
                {
                     g[i]='C';
                }
                else if(p[i]>=30 && p[i]<=59)
                {
                     g[i]='D';
                }
                else if( p[i]<30)
                {
                     g[i]='F';
                }
           }
           System.out.println();
           for(int i=0;i<n;i++)
           {
                c = g[i];
 
           }
           return c;
      }
      void Sort(int n)
      {
           String temp;
           int r=0;
           int mj=0,mc=0,md=0;
 
           for(int i=0;i<n;i++)
           {
              for(int j=i+1;j<n;j++)
              {
                  if(name[i].compareTo(name[j])>0)
                  {
                       temp=name[i];
                       r = roll_no[i];
                       mj=marks_java[i];
                       mc=marks_co[i];
                       md=marks_dm[i];
                       name[i] =name[j];
                       roll_no[i]=roll_no[j];
                       marks_java[i]=marks_java[j];
                       marks_co[i]=marks_co[j];
                       marks_dm[i]=marks_dm[j];
                       name [j] = temp;
                       roll_no[j]=r;
                       marks_java[j]=mj;
                       marks_co[j]=mc;
                       marks_dm[j]=md;
                  }
               }
            }
       }
 
       void edisplay(int n , int m)
       {
            System.out.println("\t\t\t\tUniversity Name--" +Univ_name);
            System.out.printf("%-15s%-20s%-17s%-15s%-15s%-15s%10s\n\n", "Roll no." , "Student name" , "Marksjava" , "Marksco" , "Marksdm" , "Percentage" , "Grade");
            Sort(n);
            Calc_grade(n);
            for(int i=0; i<n;i++)
            {
                if(i==m)
                {
                       System.out.printf("%-18d%-19s%-18d%-15d%-13d%-9.2f%13c\n",roll_no[i],name[i],marks_java[i],marks_co[i],marks_dm[i],p[i],g[i]);
                       System.out.println();
                }
            }
        }
 
        void display(int n)
        {
              Scanner sc =new Scanner(System.in);
              System.out.println("\t\t\t\tUniversity Name--" +Univ_name);
              System.out.printf("%-15s%-20s%-17s%-15s%-15s%-15s%10s\n\n", "Roll no." , "Student name" , "Marksjava" , "Marksco" , "Marksdm" , "Percentage" , "Grade");
              Sort(n);
              for(int i=0; i<n;i++)
              {
                     System.out.printf("%-18d%-19s%-18d%-15d%-13d%-9.2f%13c\n",roll_no[i],name[i],marks_java[i],marks_co[i],marks_dm[i],p[i],g[i]);
                     System.out.println();
              }

        }
 
        public static void main(String[] args) 
        {
             Scanner sc = new Scanner(System.in);
             Student stud = new Student();
             System.out.println(" ");
             System.out.println();
             System.out.println();
             System.out.println("Enter the number of the students : ");
             int n = sc.nextInt();
             int c = stud.input(n);
             try
             {
                   stud.Calc_grade(n);
                   stud.Sort(n);
                   stud.display(n);
             }
             catch(Exception e)
             {
                   return;
             }
 
        }
}