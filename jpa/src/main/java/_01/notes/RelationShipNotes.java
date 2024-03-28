package _01.notes;

public class RelationShipNotes {
}

// Bir Entity RelationShip için:

// 1 - Role
// 2 - Directionality
// 3 - Cardinality
// 4 - Ordinality / Optionality

// ROLE
// Bir ilişkide 2 tarafın varlığı gerekli / söz konusudur.
// Her ilişki için 2 tane Entity vardır.
// Employee -department

// DIRECTIONALITY
// - Unidirectional
// - BiDirectional

// Bir ilişkide, 2 entityden sadece birisi diğerini gösteriyorsa / point bu durumda Unidirectionaldir.
// Birbirlerini gösteriyorsa Bidirectionaldir.

// Unidirectional : --> or <--
// Bidirectional  : <-------->

// CARDINALITY
// Cardinal -> önemli, asil, nicelik

// Bir employee, sadece 1 departmana bağlı olabilir.
// Bir departmanda N tane employee olabilir.
// Bir Employee N tane Phone olabilir.
// Bir Phone sadece bir Employee ait olabilir.

// 1 Employee N tane Project çalışabilir.
// 1 Proh-ject M tane Employee olabilir.

// Cardinality kavramından kastımız bir ilişkide şu ifadelerdir. :

// OneToOne
// OneToMany
// ManyToOne
// ManyToMany

// ORDINALITY / OPTIONALITY
// zorunlu / mandotary ya da seçimlik / optional olup olmaması ile ilgili bir kavramdır.

// Customer - BillingInfo
// her customer için billinginfo olmak zorunda değildir.
// BillingInfo bizim için zorunlu değil. optional/seçimliliktir.

// Single-valued RelationShip
// @OneToOne
// @ManyToOne

// Collection-valued RelationShip
// @ManyToMany
// @OneToMany

