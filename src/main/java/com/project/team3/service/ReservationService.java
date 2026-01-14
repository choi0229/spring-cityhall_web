package com.project.team3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.team3.dao.ReservationDAO;
import com.project.team3.vo.Reservation;


@Service
public class ReservationService {

    @Autowired
    private ReservationDAO dao;

    @Transactional
    public int createReservation(Reservation reservation) {
        int overlapCount = dao.checkOverlap(reservation);

        if (overlapCount > 0) {
            throw new IllegalStateException("이미 예약된 시간입니다.");
        }

        return dao.createRsv(reservation);
    }

    @Transactional
    public int updateReservation(Reservation reservation) {
        int overlapCount = dao.checkOverlapforUpdate(reservation);

        if (overlapCount > 0) {
            throw new IllegalStateException("변경하려는 시간에 이미 예약이 있습니다.");
        }

        return dao.updateRsv(reservation);
    }

}