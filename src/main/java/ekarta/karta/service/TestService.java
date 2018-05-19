package ekarta.karta.service;

import ekarta.karta.entity.Test;
import ekarta.karta.service.repository.TestRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TestService {
    private  final TestRepository testRepository;

    public TestService(TestRepository testRepository){ this.testRepository=testRepository;}
    public List<Test> findAll(){return (ArrayList<Test>)testRepository.findAll();
    }
}
