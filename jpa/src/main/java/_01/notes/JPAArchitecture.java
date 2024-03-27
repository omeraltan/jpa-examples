package _01.notes;

public class JPAArchitecture {

}

// Metadata / ustveri
// - Annotation
// - XML

// JPA
// javax.persistence.EntityManagerFactory
// javax.persistence.EntityManager
// javax.persistence.EntityTransaction
// javax.persistence.Persistence

// @PersistenceContext
// @PersistenceUnit

// Persistence sınıfından, EntityManagerFactory elde edebiliriz.
// 1 Persistence N tane EntityManagerFactory oluşturabilir.
// EntityManagerFactory -> EntityManager oluşturabiliriz.
// 1 EntityManagerFactory N tane EntityManager oluşturabiliriz.
// 1 EntityManagerFactory 1 PersistenceUnit tarafından konfigure edilir.
// public EntityManager createEntityManager();
// EntityManager, Entity'ler üzerinde yaptığımız işlemlerden sorumludur.
// EntityManager -> EntityTransaction'ları elde ederiz.
// EntityManager tarafından yönetilen/managed edilen tüm Entity obje kümesine PersistenceContext adı verilir.

// Persistence Unit
// persistence.xml dosyasında konfigurasyon bilgileriniz yer alacak.
// Persistence Unit -> entity classlarının belirtildiği, veritabanı bilgilerinin yer aldığı konfigurasyon bilgisi.

// ### source folder altında META-INF klasörü altında yer almalıdır!!!

