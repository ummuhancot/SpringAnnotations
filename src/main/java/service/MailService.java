package service;

import domain.Message;
import repository.DbRepository;
import repository.FileRepository;
import repository.Repository;

public class MailService implements MessageService{

    //private DbRepository repo=new DbRepository();//mailservice dbrepositorye sıkı sıkı bağımlı olur

    // private Repository repo=new FileRepository();
    private Repository repo;//null

    //param const
    public MailService(Repository repo) {
        this.repo = repo;
    }

    public void sendMessage(Message message){
        System.out.println("Mesajınız mail ile gönderiliyor...Mesaj: "+message.getBody());
    }

    @Override
    public void saveMessage(Message message) {
        //DbRepository repo=new DbRepository();
        repo.save(message);

    }

}