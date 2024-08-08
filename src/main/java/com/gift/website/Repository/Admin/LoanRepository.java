package com.gift.website.Repository.Admin;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gift.website.Modal.Admin.LoanModel;

@Repository
public interface LoanRepository extends JpaRepository<LoanModel, Long> {
}
