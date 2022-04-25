package projetFormation.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import projetFormation.model.Notification;

public interface INotificationRepository extends JpaRepository<Notification, Long> {

}
