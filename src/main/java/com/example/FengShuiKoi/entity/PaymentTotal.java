package com.example.FengShuiKoi.entity;

<<<<<<< HEAD
import com.example.FengShuiKoi.entity.Enum.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

=======
import jakarta.persistence.*;
import lombok.Data;
>>>>>>> origin/forgot-password
import java.util.Date;
import java.util.List;

@Entity
<<<<<<< HEAD
@Setter
@Getter
public class PaymentTotal {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    int id;
    int order_id;
    int amount;
    Date pay_date;
    int pay_method;

    @Enumerated(EnumType.STRING)
    PaymentStatus pay_status;

    @OneToMany(mappedBy = "paymentTotal")
    List<PaymentMethod> paymentMethodList;

    @OneToOne(mappedBy = "paymentTotal")
    OrderProduct orderProduct;


    @OneToOne(mappedBy = "paymentTotal")
    Invoice invoice;

    @OneToMany(mappedBy = "paymentTotal")
    List<Plan> planList;
}
=======
@Data
@Table(name = "payment_total")
public class PaymentTotal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int payId;

    @Column(name = "order_id", insertable = false, updatable = false)
    int orderId;

    int amount;
    Date payDate;
    int payMethod;

    @Enumerated(EnumType.STRING)
    PaymentStatus payStatus;

//    @OneToMany(mappedBy = "paymentTotal", cascade = CascadeType.ALL, orphanRemoval = true)
//    List<PaymentMethod> payment;
//
//    @OneToOne
//    @JoinColumn(name = "order_id", referencedColumnName = "ordId")
//    OrderProduct order;
//
//    @OneToOne
//    @JoinColumn(name = "order_plan_id", referencedColumnName = "opId")
//    OrderPlan orderPlan;
}
>>>>>>> origin/forgot-password
