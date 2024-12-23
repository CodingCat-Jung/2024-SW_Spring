package edu.sch.dwitterserver.service;

import edu.sch.dwitterserver.domain.Dwitter;
import edu.sch.dwitterserver.repository.SpringDataJpaDwitterRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class DwitterService {

    private final SpringDataJpaDwitterRepository dwitterDao;

    @Autowired
    public DwitterService(SpringDataJpaDwitterRepository dwitterDao) {
        this.dwitterDao = dwitterDao;
    }

    /**
     * 리스트 조회
     */
    public List<Dwitter> findDwitters() {
        return dwitterDao.findAll();
    }

    /**
     * 등록
     */
    public Dwitter register(Dwitter dwitter) {
        Dwitter saveDwitter = dwitterDao.save(dwitter);
        return saveDwitter;
    }

    /**
     * 삭제
     */
    public void delete(Dwitter dwitter) {
        dwitterDao.delete(dwitter);
    }

    public List<Dwitter> findAll(){
        return dwitterDao.findAll();
    }
}



//package edu.sch.dwitterserver.service;
//
//import edu.sch.dwitterserver.domain.Dwitter;
//import edu.sch.dwitterserver.repository.SpringDataJpaDwitterRepository;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Transactional // class 자동 생성
//@Service
//public class DwitterService {
//    /* Controller -> DB (Repository 객체 생성)
//     *
//     * CRUD Repository
//     * 등록: Register가 아닌 save (Override)
//     * 조회: findAll(), 삭제: delete()
//     */
//
//    private final SpringDataJpaDwitterRepository dwitterDao;
//    /*Singletone Pattern (1개만 생성하겠음)*/
//
//    // DI by constructor
//    @Autowired
//    public DwitterService(SpringDataJpaDwitterRepository dwitterDao) {
//        this.dwitterDao = dwitterDao;
//    }
//
//    public Dwitter save(Dwitter dwitter){
//        //repository register method (save)
//        return dwitterDao.save(dwitter);
//    }
//
//    public List<Dwitter> findAll(){
//        return dwitterDao.findAll();
//    }
//
//    public void delete(Dwitter dwitter /*Entity*/){
//        dwitterDao.delete(dwitter);
//    }
//}
