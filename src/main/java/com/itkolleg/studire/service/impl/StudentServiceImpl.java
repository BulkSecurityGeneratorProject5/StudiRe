package com.itkolleg.studire.service.impl;

import com.itkolleg.studire.service.StudentService;
import com.itkolleg.studire.domain.Student;
import com.itkolleg.studire.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing Student.
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private String martikelnummer;
    private String tuGraz = "30";

    private final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Save a student.
     *
     * @param student the entity to save
     * @return the persisted entity
     */
    @Override
    public Student save(Student student) {
        log.debug("Request to save Student : {}", student);

        log.debug("Request to save Student : {}", student);

        Student forId = studentRepository.save(student);

        String id = String.format("%03d", forId.getId());
        id = id.substring(0,3);

        Date d = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yy");
        String currentYear = dateFormat.format(d);


        martikelnummer = currentYear+tuGraz+id;

        forId.setMatrikelNummer(Long.parseLong(martikelnummer));

        return studentRepository.save(forId);
    }

    /**
     * Get all the students.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        log.debug("Request to get all Students");
        return studentRepository.findAll();
    }


    /**
     * Get one student by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Student> findOne(Long id) {
        log.debug("Request to get Student : {}", id);
        return studentRepository.findById(id);
    }

    /**
     * Delete the student by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Student : {}", id);
        studentRepository.deleteById(id);
    }
}
