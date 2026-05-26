# Gallery Management Project

Bu proje, bir oto galeri yönetim sistemi için geliştirilmiş kapsamlı bir arka uç (backend) uygulamasıdır. Spring Boot altyapısı kullanılarak inşa edilmiş olup, araç alım-satım süreçlerini, galeri yöneticilerini, müşteri hesaplarını ve yetkilendirme işlemlerini tek bir merkezden yönetmeyi amaçlar.

## Temel Özellikler

- Kullanıcı ve Yetkilendirme (Auth): Spring Security ve JWT (JSON Web Token) kullanılarak güvenli kullanıcı giriş-çıkış işlemleri ve oturum yönetimi (Refresh Token) sağlanır.
- Galeri ve Araç Yönetimi: Galerilerin sistemde tanımlanması, galerilere ait araçların envanterinin tutulması ve araç özelliklerinin yönetilmesi işlemleri gerçekleştirilir.
- Müşteri ve Satış Yönetimi: Müşteri profillerinin oluşturulması, adres ve bakiye/hesap durumlarının tutulması ile gerçekleştirilen araç satışlarının kayıt altına alınması sağlanır.
- Döviz Kuru Entegrasyonu: Araç fiyatlandırmalarında veya ödemelerde kullanılmak üzere anlık döviz kurlarının alınabilmesini sağlayan bir yapı içerir.
- Standart Hata Yönetimi: Sistem genelinde oluşabilecek hatalar merkezi bir yapı üzerinden yakalanarak, istemciye düzenli ve anlaşılır hata mesajları olarak iletilir.

## Mimari ve Teknolojiler

Proje standart katmanlı mimari (Controller, Service, Model/Entity, Repository) yaklaşımıyla geliştirilmiştir. Dışarıya açılan uç noktalarda (endpoint) Veri Aktarım Objeleri (DTO) kullanılarak veri güvenliği ve bütünlüğü sağlanmıştır.

Kullanılan başlıca teknolojiler şunlardır:
- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- JWT (JSON Web Token)
- Lombok
- Maven
