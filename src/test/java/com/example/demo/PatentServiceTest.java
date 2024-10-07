package com.example.demo;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.Entity.Patent;
import com.example.demo.repo.PatentRepo;
import com.example.demo.service.PatentService;

public class PatentServiceTest {
	
	
	
	@Mock
    private PatentRepo patentRepo;

    @InjectMocks
    private PatentService patentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreatePatent() {
        // Arrange
        Patent patent = new Patent(); // Assuming you have a constructor or setters to set values
        when(patentRepo.save(any(Patent.class))).thenReturn(patent);

        // Act
        Patent savedPatent = patentService.createPatent(patent);

        // Assert
        assertEquals(patent, savedPatent);
        verify(patentRepo).save(patent);
    }

    @Test
    public void testGetAllPatents() {
        // Arrange
        Patent patent1 = new Patent(); // Assuming you have a constructor or setters to set values
        Patent patent2 = new Patent();
        List<Patent> patents = Arrays.asList(patent1, patent2);
        when(patentRepo.findAll()).thenReturn(patents);

        // Act
        List<Patent> result = patentService.getAllPatents();

        // Assert
        assertEquals(2, result.size());
        assertEquals(patent1, result.get(0));
        assertEquals(patent2, result.get(1));
        verify(patentRepo).findAll();
    }

    @Test
    public void testGetPatents_Success() {
        // Arrange
        Patent patent = new Patent(); // Assuming you have a constructor or setters to set values
        when(patentRepo.findById(1)).thenReturn(Optional.of(patent));

        // Act
        Patent result = patentService.getPatents(1);

        // Assert
        assertEquals(patent, result);
        verify(patentRepo).findById(1);
    }

    @Test
    public void testGetPatents_NotFound() {
        // Arrange
        when(patentRepo.findById(1)).thenReturn(Optional.empty());

        // Act
        Patent result = patentService.getPatents(1);

        // Assert
        assertNull(result); // No patent should be found
        verify(patentRepo).findById(1);
    }

    @Test
    public void testDeleteId() {
        // Arrange
        int patentId = 1;
        doNothing().when(patentRepo).deleteById(patentId);

        // Act
        patentService.deleteId(patentId);

        // Assert
        verify(patentRepo).deleteById(patentId);
    }
}