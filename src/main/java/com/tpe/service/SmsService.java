package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/*
1. Constructor Injection (Yapıcı Yöntem ile Enjeksiyon)
Bu yöntemde, bağımlılıklar sınıfın constructor (yapıcı) yöntemi aracılığıyla sağlanır.

Spring, bağımlılıkları belirlenen constructor üzerinden enjekte eder.
Sınıfın bağımlılıklarını zorunlu kılmak için idealdir.

Bağımlılıklar zorunlu olduğundan, bağımlılıklar eksik olduğunda kod derleme aşamasında hata verir.
Sınıfın bağımlılıkları net bir şekilde görülür.
2. Setter Injection (Setter Yöntem ile Enjeksiyon)
Bağımlılıklar, setter metotları aracılığıyla enjekte edilir.

Spring, bağımlılıkları setter metotları aracılığıyla sağlar.

Bağımlılıkların isteğe bağlı olması durumunda kullanışlıdır.
Bağımlılıklar çalışma zamanında değiştirilebilir.

Bağımlılıklar zorunlu değilmiş gibi görünebilir ve yanlış konfigürasyonlara neden olabilir.
3. Field Injection (Alan Üzerinden Enjeksiyon)
Bağımlılıklar doğrudan sınıfın alanlarına enjekte edilir.

@Autowired anotasyonu, alanın üzerine doğrudan eklenir.
Spring, bağımlılığı doğrudan alan seviyesinde enjekte eder.

Kısa ve okunması kolaydır.
Kod daha az karmaşık görünür.

Alanlar genellikle private olduğundan, test etmek zordur (Mocking araçları gerekebilir).
Bağımlılıkları açık bir şekilde görme olanağı azalır.

Spring'de modern projelerde genellikle Constructor Injection tercih edilir çünkü:
Bağımlılıklar zorunlu hale gelir.
Nesneler final anahtar kelimesiyle tanımlanarak değişmez hale getirilebilir.
Test edilebilirlik daha kolaydır.
*/

//bir clasın objelerinin spring tarafından görevli olmasını istiyorsak @Component sprink tarafından olusturulup yönetilecek diyoruz bu classlara
//sprink @Bean denir.
@Component("sms_service")
public class SmsService implements MessageService{

//-----------------------------------------------//

         ///filed injection
//    @Autowired//bağımlılığın enjekte edilmesini sağlar yani otomatik olarak baglantı kurar
//    @Qualifier("fileRepository")//belirleyici secim yapıcı birden fazla implemente eden bean varsa yazarız ismini
//    // birden fazla aynı data tipinde bean varsa belirleyici görevini görür.
//    private Repository repo;

//-----------------------------------------------//

        ///setter injection
//    private Repository repo;
//    @Autowired
//    @Qualifier("fileRepository")
//    public void setRepo(Repository repo) {
//        this.repo = repo;
//    }

//-----------------------------------------------//
     //önerilir//
        ///constructor injection
    private Repository repo;
    @Autowired
    public SmsService(@Qualifier("fileRepository") Repository repo) {
        this.repo = repo;
    }

//------------------------------------------------//

    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesajınız sms ile gönderiliyor . Mesaj : "+message.getBody());
    }

    @Override
    public void saveMessage(Message message) {
        repo.save(message);
    }

//-------------------------------------------------//

    @PostConstruct
    public void postConstruct(){
        System.err.println("--------sms service objesi üretildi.");
    }

    @PreDestroy
    public void preDestroy(){
        System.err.println("--------sms service objesi imha edildi.");
    }

}
