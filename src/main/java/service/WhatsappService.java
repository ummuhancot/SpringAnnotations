package service;

import domain.Message;
import repository.FileRepository;
import repository.Repository;

public class WhatsappService implements MessageService{

    //private Repository repo=new FileRepository();

    private Repository repo;

    public WhatsappService(Repository repo) {
        this.repo = repo;
    }

    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesajınız whatsapp ile gönderiliyor...Mesaj: "+message.getBody());
    }

    @Override
    public void saveMessage(Message message) {
        repo.save(message);
    }
}