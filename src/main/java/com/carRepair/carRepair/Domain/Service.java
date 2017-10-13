package com.carRepair.carRepair.Domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id" ,nullable = false)
    private long serviceId;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date time;

    @Column(nullable = false, length = 1)
    private int status;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean type;

    @ManyToOne(optional = false)
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private Member member;

    public Service(){}

    public Service(long serviceId, Date date, Date time, int status, String description, boolean type, Member member) {
        this.serviceId = serviceId;
        this.date = date;
        this.time = time;
        this.status = status;
        this.description = description;
        this.type = type;
        this.member = member;

    }

    public long getServiceId() { return serviceId; }



    public void setServiceId(long serviceId) { this.serviceId = serviceId; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public Date getTime() { return time; }



    public void setTime(Date time) { this.time = time; }

    public int getStatus() { return status; }

    public void setStatus(int status) { this.status = status; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public boolean isType() { return type; }

    public void setType(boolean type) { this.type = type; }

   /*public Member getMember() {

       return member;

   }
   public void setMember(Member member) {

       this.member = member;

   }*/

}
