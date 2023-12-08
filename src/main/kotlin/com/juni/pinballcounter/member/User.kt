package com.juni.pinballcounter.member

import jakarta.persistence.*


@Entity
class User(
    name: String,
    teamName: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

    @Column(nullable = false)
    var name: String = name
        private set

    @Column(nullable = false)
    var teamName: String = teamName
        private set
}