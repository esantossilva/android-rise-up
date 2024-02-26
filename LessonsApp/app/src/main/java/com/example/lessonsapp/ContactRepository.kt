package com.example.lessonsapp

interface ContactRepositoryInteractor {
    fun addContact(contact: Contact)
    fun getContact(id: Int): Contact?
    fun getContactList(): List<Contact>
    fun removeContact(contact: Contact)
}

class ContactRepositoryFake : ContactRepositoryInteractor {

    private val contactList = mutableListOf(
        Contact(1, "João", "joao@gmail.com", "8199990001"),
        Contact(2, "Amanda", "amanda@gmail.com", "8199990002"),
        Contact(3, "José", "jose@gmail.com", "8199990003"),
        Contact(4, "Cecília", "cecilia@gmail.com", "8199990004"),
    )

    override fun addContact(contact: Contact) {
        if (!contactList.contains(contact)) contactList.add(contact)
    }

    override fun getContact(id: Int): Contact? =
        contactList.find { it.id == id }

    override fun getContactList(): List<Contact> = contactList

    override fun removeContact(contact: Contact) {
        if (contactList.contains(contact)) contactList.remove(contact)
    }
}