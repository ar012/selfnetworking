package com.selftics.snet

import com.selftics.snet.GlobalConfig

class Member {

    Integer id
    String firstName
    String lastName
    String email
    String password
    String memberType = GlobalConfig.USER_TYPE.REGULAR_MEMBER
    String identityHash
    Long identityHashLashUpdate
    Boolean isActive = true

    Date dateCreated
    Date lastUpdated

    static constraints = {
        email(email: true, nullable: false, unique: true, blank: false)
        password(blank: false)
        lastName(nullable: true)
        identityHash(nullable: true)
        identityHashLashUpdate(nullable: true)
    }

    def beforeInsert(){
        this.password = this.password.encodeAsMD5()
    }

    def beforeUpdate(){
        this.password = this.encodeAsMD5()
    }
}
