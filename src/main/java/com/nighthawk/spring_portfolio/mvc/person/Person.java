package com.nighthawk.spring_portfolio.mvc.person;

import static jakarta.persistence.FetchType.EAGER;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.format.annotation.DateTimeFormat;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Convert(attributeName = "person", converter = JsonType.class)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(min = 5)
    @Column(unique = true)
    @Email
    private String email;

    @NotEmpty
    private String password;

    private Integer eco;

    @NotEmpty
    private String primaryCrop;

    private Integer cash;

    @NonNull
    @Size(min = 2, max = 30, message = "Name (2 to 30 chars)")
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    @ManyToMany(fetch = EAGER)
    private Collection<PersonRole> roles = new ArrayList<>();

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String, Map<String, Object>> stats = new HashMap<>();

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String, Integer> integerMap = new HashMap<>();

    public Person(String email, String password, String name, Integer eco, String primaryCrop, Integer cash, Date dob) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.eco = eco;
        this.primaryCrop = primaryCrop;
        this.cash = cash;
        this.dob = dob;
    }

    public Person(String email, String password, String name, Date dob) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.dob = dob;
    }

    public int getAge() {
        if (this.dob != null) {
            LocalDate birthDay = this.dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            return Period.between(birthDay, LocalDate.now()).getYears();
        }
        return -1;
    }

    public static Person[] init() {
        Person p1 = new Person();
        p1.setName("h4seebcmd");
        p1.setEmail("mirzahbeg123@gmail.com");
        p1.setPassword("notTellingYouLOL");
        p1.setEco(-5);
        p1.setPrimaryCrop("corn");
        p1.setCash(52);
        p1.getIntegerMap().put("Team 1", 1);
        p1.getIntegerMap().put("Team 2", 40);
        try {
            Date d = new SimpleDateFormat("MM-dd-yyyy").parse("12-06-2007");
            p1.setDob(d);
        } catch (Exception e) {
        }

        Person p2 = new Person();
        p2.setName("tirthFarmer999");
        p2.setEmail("ermitsactuallypronouncedwithaTHUH@gmail.com");
        p2.setPassword("iLOVEagricutlre");
        p2.setEco(8);
        p2.setCash(14);
        p2.setPrimaryCrop("corn");
        p2.getIntegerMap().put("Team 1", 1);
        p2.getIntegerMap().put("Team 2", 40);
        try {
            Date d2 = new SimpleDateFormat("MM-dd-yyyy").parse("01-01-2024");
            p2.setDob(d2);
        } catch (Exception e) {
        }

        Person persons[] = { p1, p2 };
        return persons;
    }

    public static void initializeIntegerMaps(Person[] persons) {
        for (Person person : persons) {
            Map<String, Integer> integerMap = person.getIntegerMap();
            if (integerMap.isEmpty()) {
                integerMap.put("value1", 10);
                integerMap.put("value2", 20);
                integerMap.put("value3", 30);
            }
        }
    }

    public static void main(String[] args) {
        Person[] persons = init();
        initializeIntegerMaps(persons);
        for (Person person : persons) {
            System.out.println("Name: " + person.getName());
            System.out.println("Email: " + person.getEmail());
            System.out.println("Password: " + person.getPassword());
            System.out.println("Date of Birth: " + person.getDob());
            System.out.println("Age: " + person.getAge());
            System.out.println("Integer Map: " + person.getIntegerMap());
            System.out.println("---------------------------------");
        }
    }
}
