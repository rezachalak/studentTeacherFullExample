package view;

import entities.Entity;
import entities.Student;
import entities.Teacher;
import manager.StudentManager;
import manager.TeacherManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private StudentManager stdMgn = StudentManager.getStudentManagerInstance();
    private TeacherManager tchrMgn = TeacherManager.getTeacherManagerInstance();
    private JRadioButton addStudent;
    private JRadioButton addTeacher;
    private JRadioButton removeStudent;
    private JRadioButton showStudents;
    private JRadioButton showTeachers;
    private JRadioButton findStudentsTeacher;
    private JLabel label;
    private JTextArea area;
    private JButton action;
    private JButton exit;
    private JFrame f;
    private JPanel infoPanel;

    
    UserInterface() {
        label = new JLabel("Select action to do:");
        label.setBounds(30, 0, 200, 40);
        addStudent = new JRadioButton("Add student");
        addStudent.setBounds(50, 30, 200, 40);
        addTeacher = new JRadioButton("Add teacher");
        addTeacher.setBounds(50, 60, 200, 40);
        removeStudent = new JRadioButton("Remove student");
        removeStudent.setBounds(50, 90, 200, 40);
        showStudents = new JRadioButton("Show all students");
        showStudents.setBounds(50, 120, 200, 40);
        showTeachers = new JRadioButton("Show all teachers");
        showTeachers.setBounds(50, 150, 200, 40);
        findStudentsTeacher = new JRadioButton("Find student's teacher");
        findStudentsTeacher.setBounds(50, 180, 200, 40);
        area = new JTextArea("Execution log:\n");
        area.setBounds(300, 20, 400, 300);
        action = new JButton("Do action");
        action.setBounds(70, 230, 150, 40);
        exit = new JButton("Exit");
        exit.setBounds(70, 275, 150, 40);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(addStudent);
        buttonGroup.add(addTeacher);
        buttonGroup.add(removeStudent);
        buttonGroup.add(showStudents);
        buttonGroup.add(showTeachers);
        buttonGroup.add(findStudentsTeacher);

        add(addStudent);
        add(addTeacher);
        add(removeStudent);
        add(showStudents);
        add(showTeachers);
        add(findStudentsTeacher);
        add(action);
        add(area);
        add(label);
        add(exit);
        setSize(750, 350);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(3);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
        action.addActionListener(this::actionPerformed);
    }

    public void actionPerformed(ActionEvent e) {
        if (addStudent.isSelected()) {
//            JOptionPane.showMessageDialog(sex, "You are Male.");
            this.addStudent();
        } else if (addTeacher.isSelected()) {
            this.addTeacher();
        } else if (removeStudent.isSelected()) {
//            new UserInterface(0);
        } else if (showStudents.isSelected()) {
            this.showStudentsList();
        } else if (showTeachers.isSelected()) {
            this.showTeachersList();
        } else if (findStudentsTeacher.isSelected()) {
//            new UserInterface(0);
        }

    }

    private void addStudent() {
        f = new JFrame();
        f.setTitle("Student addition Window");
        f.setSize(300, 400);
        infoPanel = new JPanel();
        JPanel stdPanel = new JPanel();
        stdPanel.setBounds(50, 50, 200, 500);
        stdPanel.add(infoPanel);
        f.add(stdPanel);

        infoPanel.setLayout(new GridLayout(6, 2));
//        f.add(infoPanel);
        JTextField studentName = new JTextField();
        JLabel studentNameLbl = new JLabel("Student Name");

        JTextField studentId = new JTextField();
        JLabel studentIdLbl = new JLabel("Student ID");

        JTextField studentAge = new JTextField();
        JLabel studentAgeLbl = new JLabel("Age");

        JTextField studentDept = new JTextField();
        JLabel studentDeptLbl = new JLabel("Department Name");

        JTextField studentsTeacher = new JTextField();
        JLabel studentsTeacherLbl = new JLabel("Student's Teacher ID");

        JButton add = new JButton("Add");
        infoPanel.add(studentIdLbl);
        infoPanel.add(studentId);
        infoPanel.add(studentAgeLbl);
        infoPanel.add(studentAge);
        infoPanel.add(studentNameLbl);
        infoPanel.add(studentName);
        infoPanel.add(studentDeptLbl);
        infoPanel.add(studentDept);
        infoPanel.add(studentsTeacherLbl);
        infoPanel.add(studentsTeacher);
        JLabel blank = new JLabel("");
        infoPanel.add(blank);
        infoPanel.add(add);
        f.setVisible(true);
//        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Student student = new Student();
                try {
                    student.setName(studentName.getText());
                    student.setId(Integer.valueOf(studentId.getText()));
                    student.setDepartment(studentDept.getText());
                    student.setAge(Integer.valueOf(studentAge.getText()));
                    student.setTeacherId(Integer.valueOf(studentsTeacher.getText()));
                    stdMgn.create(student);
                    area.append("Student " + student.getName() + " added");
                } catch (Exception e) {
                    area.append("An exception occurred during student adding:\n" + e.toString() + "\n");
                } finally {
                    f.dispose();
                }

            }
        });
    }

    private void addTeacher() {
        f = new JFrame();
        f.setTitle("Teacher addition Window");
        f.setSize(300, 400);
        infoPanel = new JPanel();
        JPanel tchrPanel = new JPanel();
        tchrPanel.setBounds(50, 50, 200, 300);
        f.add(tchrPanel);
        tchrPanel.add(infoPanel);
        infoPanel.setLayout(new GridLayout(4, 2));
        JTextField teacherName = new JTextField();
        JLabel teacherNameLbl = new JLabel("Teacher Name");

        JTextField teacherId = new JTextField();
        JLabel teacherIdLbl = new JLabel("Teacher ID");

        JTextField teacherDept = new JTextField();
        JLabel teacherDeptLbl = new JLabel("Department Name");

        JButton addBtn = new JButton("Add");
        infoPanel.add(teacherIdLbl);
        infoPanel.add(teacherId);
        infoPanel.add(teacherNameLbl);
        infoPanel.add(teacherName);
        infoPanel.add(teacherDeptLbl);
        infoPanel.add(teacherDept);
        JLabel blankLbl = new JLabel("");
        infoPanel.add(blankLbl);
        infoPanel.add(addBtn);
        f.setVisible(true);
//        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Teacher teacher = new Teacher();
                try {
                    teacher.setTeacherName(teacherName.getText());
                    teacher.setId(Integer.valueOf(teacherId.getText()));
                    teacher.setDepartment(teacherDept.getText());
                    tchrMgn.create(teacher);
                    area.append("Teacher " + teacher.getTeacherName() + " added");
                } catch (Exception e) {
                    area.append("An exception occurred during teacher adding:\n" + e.toString() + "\n");
                } finally {
                    f.dispose();
                }
            }
        });
    }

    private void showStudentsList() {
        f = new JFrame();
        f.setTitle("Students List");
        f.setSize(300, 400);
        String[][] data;
        try {
            Student[] students = (Student[]) stdMgn.getList();
            data = new String[students.length][5];
            int i = 0;
            for (Student student : students) {
                data[i][0] = String.valueOf(student.getId());
                data[i][1] = student.getName();
                data[i][2] = String.valueOf(student.getAge());
                data[i][3] = student.getDepartment();
                data[i][4] = String.valueOf(student.getTeacherId());
                i++;
            }
            String column[] = {"ID", "Name", "Age", "Department", "TeacherID"};
            JTable jt = new JTable(data, column);
            jt.setBounds(30, 40, 200, 300);
            JScrollPane sp = new JScrollPane(jt);
            f.add(sp);
            f.setSize(300, 400);
            f.setVisible(true);
        } catch (Exception e) {
            area.append("An Exception occurred during loading students list:\n" + e.toString() + "\n");
            e.printStackTrace();
        }

    }

    private void showTeachersList() {
        f = new JFrame();
        f.setTitle("Teachers List");
        f.setSize(300, 400);
        String[][] data;
        try {
            Teacher[] teachers = (Teacher[]) tchrMgn.getList();
            data = new String[teachers.length][5];
            int i = 0;
            for (Teacher teacher : teachers) {
                data[i][0] = String.valueOf(teacher.getId());
                data[i][1] = teacher.getTeacherName();
                data[i][2] = teacher.getDepartment();
                i++;
            }
            String column[] = {"ID", "Name", "Department"};
            JTable jt = new JTable(data, column);
            JScrollPane sp = new JScrollPane(jt);
            jt.setBounds(30, 40, 200, 300);
            f.add(sp);
            f.setSize(300, 400);
            f.setVisible(true);
        } catch (Exception e) {
            area.append("An Exception occurred during loading teacher list:\n" + e.toString() + "\n");
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new UserInterface();
    }

}


