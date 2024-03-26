package _01.notes;

public class HelloEntity {
}

// Entity
// Entity -> Varlık gibi bir türkçe karşılığı vardır.
// JPA açısından Entity -> "kalıcı nesne/persistent object" ifadesi daha doğru bir yaklaşım olacaktır.

// Entity'lerin özellikleri:
// Persistability
// Entity'lerin kalıcı hale gelme özelliği olmalıdır.

// Identity
// Identity -> kimlik
// Entity, veritabanına kaydedildiğinde unique / tekil bir identity / kimlik bilgisine sahip olmalıdır.
// primary key bilgisi

// Transactionality
// Transaction -> türkçe karşılığı işlemdir.
//
// Örnek bir transaction akışı :

// 1 - koltuğu seç
// 2 - koltuk adına rezerve olsun
// 3 - ödeme yap
// 4 - bileti al

// bu dört adıma transaction adını veriyoruz.
// herhangi bir adımda problem oluştuğunda revert / roll back edilir.
// herşey başarılı ise commit edilir.

// transaction ->
// 1 - programmatic transaction
// 2 - declarative transaction

// ACID
// Atomicity
// Consistent
// Isolated
// Durability


// Granularity
// granur -> tanecikli olma, ortalama oge boyutu turkçe karşılık olarak

// java.lang.String entity olamaz. Attribute olabilir.
// Wrapper sınıflar entity olamaz.


// String, Integer vs sınıflar fine-grained -> ince taneli özelliğe sahiptir bunlar entity olamaz.

// JPA spectinte:
// an entity is a lightweight persistent domain object.
// lightweight -> hafif, önemsiz gibi anlamlara gelmektedir.
