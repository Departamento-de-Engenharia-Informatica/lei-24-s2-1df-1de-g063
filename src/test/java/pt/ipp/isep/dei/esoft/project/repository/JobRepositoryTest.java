package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Job;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JobRepositoryTest {

    @Test
    void ensureJobRepositoryIsSingleton() {
        JobRepository instance1 = JobRepository.getInstance();
        JobRepository instance2 = JobRepository.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    void ensureJobIsAddedSuccessfully() {
        JobRepository jobRepository = JobRepository.getInstance();
        Job job = new Job("Software Engineer");
        jobRepository.addJob(job);
        List<Job> jobs = jobRepository.getJobs();
        assertTrue(jobs.contains(job));
    }

    @Test
    void ensureGetJobsReturnsCorrectList() {
        JobRepository jobRepository = JobRepository.getInstance();
        Job job1 = new Job("Software Engineer");
        Job job2 = new Job("Project Manager");
        jobRepository.addJob(job1);
        jobRepository.addJob(job2);
        List<Job> jobs = jobRepository.getJobs();
        assertEquals(2, jobs.size());
        assertTrue(jobs.contains(job1));
        assertTrue(jobs.contains(job2));
    }
}
