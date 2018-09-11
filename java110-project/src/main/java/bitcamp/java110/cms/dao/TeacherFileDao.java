package bitcamp.java110.cms.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherFileDao implements TeacherDao{
    private List<Teacher> list = new ArrayList<>();

    public TeacherFileDao() {
        File dataFile=new File("data/teacher.dat");
        try(
                BufferedReader br = new BufferedReader(new FileReader(dataFile))) 
        /*FileReader fr = new FileReader(dataFile);
        BufferedReader br = new BufferedReader(fr);*/
        {
            while(true) {
                String line=br.readLine();
                if(line==null)
                    break;
                String[] values=line.split(",");

                Teacher t = new Teacher();
                t.setName(values[0]);
                t.setEmail(values[1]);
                t.setPassword(values[2]);
                t.setTel(values[3]);
                t.setPay(Integer.parseInt(values[4]));
                t.setSubjects(values[5]);

                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void save() {
        File dataFile = new File("data/teacher.dat");
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(dataFile))) 
        {
            for(Teacher t : list) {
                bw.write(
                        String.format("%s,%s,%s,%s,%d,[%s]", 
                                t.getName(),
                                t.getEmail(),
                                t.getPassword(),
                                t.getTel(),
                                t.getPay(),
                                t.getSubjects())
                        );
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
    }
    
    
    
    public int insert(Teacher teacher) {
        for(Teacher item : list) {
            if(item.getEmail().equals(teacher.getEmail())) {
                return 0;
            }
        }
        list.add(teacher);
        save();
        return 1;
    }
    
    public List<Teacher> findAll() {
        return list;
    }
    
    public Teacher findByEmail(String email) {
        for(Teacher item : list) {
            if(item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }
    
    public int delete(String email) {
        for(Teacher item : list) {
            if(item.getEmail().equals(email)) {
                list.remove(item);
                save();
                return 1;
            }
        }
        return 0;
    }
}
