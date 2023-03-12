package com.example.taskapp.service;

import com.example.taskapp.model.dto.ShowTaskArchiveDTO;
import com.example.taskapp.model.dto.ShowTaskDTO;
import com.example.taskapp.model.dto.TestDTO;
import com.example.taskapp.model.entity.ArchiveTasks;
import com.example.taskapp.model.entity.Employee;
import com.example.taskapp.repository.ArchiveRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatService {

    private ModelMapper modelMapper;

    private final ArchiveRepository archiveRepository;

    public StatService(ModelMapper modelMapper, ArchiveRepository archiveRepository) {
        this.modelMapper = modelMapper;
        this.archiveRepository = archiveRepository;
    }


    public List<ShowTaskArchiveDTO> getAllArchivedTasks() {
        List<ArchiveTasks> allArchivedTasks = this.archiveRepository.findAll();

        return allArchivedTasks
                .stream()
                .map(this::fromEntityToDto).collect(Collectors.toList());
    }

    private ShowTaskArchiveDTO fromEntityToDto(ArchiveTasks archiveTask) {

        return this.modelMapper.map(archiveTask, ShowTaskArchiveDTO.class);
    }

    public List<TestDTO> getTopEmployees(Long count) {


       return this.archiveRepository.findTop5Employees(count);
    }
}
