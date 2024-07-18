package com.hhdplus.concert.infrasturcture.repository;

import com.hhdplus.concert.business.domain.ReservationDomain;
import com.hhdplus.concert.infrasturcture.entity.ConcertReserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConcertReserveJpaRepository extends JpaRepository<ConcertReserve, Long> {
    /*
        Jpa의 사용이 아직도 익숙치가 않은데 join이 필요한 경우 이런식으로
        쿼리문을 사용해도 괜찮은지 궁금합니다.
     */
    @Query("SELECT cs.concertDate FROM concert_schedule cs " +
            "LEFT JOIN concert_reserve cr ON cs.id = cr.concertScheduleId " +
            "WHERE cs.concert.id = :concertId " +
            "GROUP BY cs.date " +
            "HAVING COUNT(cr.seatNo) < 50")
    List<LocalDate> findAvailableDatesByConcertId(@Param("concertId") Long concertId);

    @Query("SELECT cr.seatNo FROM concert_reserve cr " +
            "LEFT JOIN concert_schedule cs ON cr.concertScheduleId = cs.id " +
            "WHERE cs.concert.id = :concertId AND cs.date = :date")
    List<Long> findAvailableSeatByConcertIdAndDate(@Param("concertId") Long concertId, @Param("date") LocalDate date);

    @Query("SELECT cr.userId. cr.status, cs.price FROM concert_reserve cr " +
            "LEFT JOIN concert_schedule cs ON cr.concertScheduleId = cs.id " +
            "WHERE cr.concert.id = :concertId AND cr.concertScheduleId = :concertScheduleId AND cr.seatNo = :seatNo")
    ReservationDomain findUserConcertReserve(@Param("concertId")Long concertId, @Param("concertScheduleId")Long concertScheduleId, @Param("seatNo")Long seatNo);
}
