package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id; // id는 Long 으로 관리하자

    // @ManyToOne, @OneToOne 은 기본이 즉시 로딩. 따라서 지연로딩 걸어줘야
    @ManyToOne(fetch = FetchType.LAZY) // Order
    // JoinColumn 은 엔티티 간의 관계 매핑할 때 사용되며, 외래키 지정하는데 사용
    @JoinColumn(name = "member_id")
    private Member member;

    // 영속성 전이(Cascade)는 부모 엔티티의 상태 변화가 자식 엔티티에도 영향을 미치도록 하는 것을 의미
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate; // 주문 시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
