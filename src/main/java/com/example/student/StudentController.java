package com.example.student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final Map<Long, Student> students = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Long id = idGenerator.getAndIncrement();
        student.setId(id);
        students.put(id, student);
        return ResponseEntity.ok(student);
    }
    @GetMapping
    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = students.get(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        Student existing = students.get(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        existing.setFirstName(updatedStudent.getFirstName());
        existing.setLastName(updatedStudent.getLastName());
        existing.setEmail(updatedStudent.getEmail());
        return ResponseEntity.ok(existing);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        if (!students.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        students.remove(id);
        return ResponseEntity.noContent().build();
    }
}
