package com.juni.pinballcounter.dashBoard

import com.juni.pinballcounter.member.User
import jakarta.persistence.Entity

@Entity
class DashBoard(
    user: User,
    winCount: Long,
    loseCount: Long,
) {
}