package com.example.camp.domain.model

data class Book (
    val id: Int,
    val name: String,
    val author: String = "Tim Brown",
    val pages: String = "150 páginas",
    val editor: String = "Editora Loyola",
    val originName: String = "Change By Design",
    val date: String = "Publicado em 2020",
    val isbn10: String = "0065258842",
    val isbn13: String = "987-052554741",
    val language: String = "Inglês",
    val review: String = "This book describes how Design Thinking is applied across a variety of industries, enriched with other proven approaches as well as the necessary tools, and the knowledge to use them effectively. Packed with solutions for common challenges including digital transformation, this practical, highly visual discussion shows you how Design Thinking fits into agile methods within management, innovation, and startups."

) {
    companion object {
        fun getMockList() = listOf(
            Book(
                id = 1,
                name = "Crossing the Clasm"
            ),
            Book(
                id = 2,
                name = "Change By Design"
            ),
            Book(
                id = 3,
                name = "The Making of a Manager"
            ),
            Book(
                id = 4,
                name = "Don't Make me Think"
            ),
            Book(
                id = 5,
                name = "Web design 101"
            )
        )

        fun getMockListCount(count: Int): List<Book> {
            val mockList = mutableListOf<Book>()
            for(id in 1..count) {
                mockList.add(
                    Book(
                        id = id,
                        name = "Crossing the Chasm"
                    )
                )
            }
            return mockList
        }
    }
}