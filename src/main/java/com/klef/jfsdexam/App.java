package com.klef.jfsdexam;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class App {

    public static void main(String[] args) {
        insertDepartment("Computer Science", "Building A", "Dr. Smith");
        insertDepartment("Mechanical Engineering", "Building B", "Dr. Brown");
        deleteDepartmentById(1);
    }

    public static void insertDepartment(String name, String location, String hodName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            Department department = new Department();
            department.setName(name);
            department.setLocation(location);
            department.setHodName(hodName);

            session.save(department);
            transaction.commit();

            System.out.println("Department inserted successfully.");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void deleteDepartmentById(int deptId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            String hql = "DELETE FROM Department WHERE deptId = ?1";
            Query query = session.createQuery(hql);
            query.setParameter(1, deptId);

            int result = query.executeUpdate();
            transaction.commit();

            if (result > 0) {
                System.out.println("Department with ID " + deptId + " deleted successfully.");
            } else {
                System.out.println("No Department found with ID " + deptId);
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
