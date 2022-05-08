package projetFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFormation.model.Notification;
import projetFormation.repository.INotificationRepository;

@Service(value = "notificatioService")
public class NotificationService implements IService<Notification> {
	
	@Autowired
	private INotificationRepository notificationRepository;

	@Override
	public List<Notification> findAll() {
		return notificationRepository.findAll();
	}

	@Override
	public Notification saveOrUpdate(Notification obj) {
		return notificationRepository.save(obj);
	}

	@Override
	public Optional<Notification> getOne(Long id) {
		return notificationRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		notificationRepository.deleteById(id);
	}

}
