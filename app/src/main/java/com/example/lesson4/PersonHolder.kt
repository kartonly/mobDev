package com.example.lesson4

import android.os.AsyncTask
import androidx.annotation.DrawableRes
import java.util.concurrent.TimeUnit

data class Persons(
    val id: Int,
    val name: String,
    val years: String,
    val cuts: String,
    val sex: String,
    @DrawableRes val photos: Int
)

typealias activityListener = () -> Unit

object PersonHolder {
    private val id = arrayOf(
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9
    )
    private val Name = arrayOf(
        "Джим Керри",
        "Альберт Эйнштейн",
        "Елизавета 2",
        "Стив Джобс",
        "Михаил Лермонтов",
        "Мэрилин Монро",
        "Пётр 1",
        "Александр Пушкин",
        "Ре́мбрандт Ха́рменс ван Рейн",
        "Иосиф Сталин"
    )

    private val Years = arrayOf(
        "1962 - н.в",
        "1879 - 1955",
        "1926 - н.в",
        "1955 - 2011",
        "1814 - 1841",
        "1926 - 1962",
        "1672 - 1725",
        "1799 - 1837",
        "1606 - 1669",
        "1878 - 1953"
    )

    private val Cuts = arrayOf(
        "Канадо-американский актёр, телеведущий, комик, сценарист, продюсер и художник. Обладатель двух и номинант на шесть «Золотых глобусов», номинант на премию BAFTA, а также обладатель ряда других премий. ",
        "Физик-теоретик, один из основателей современной теоретической физики, лауреат Нобелевской премии по физике 1921 года, общественный деятель-гуманист. Почётный доктор около 20 ведущих университетов мира.",
        "Царствующая королева Великобритании и королевств Содружества из Виндзорской династии, верховный главнокомандующий вооружёнными силами Великобритании, верховный глава Церкви Англии, Глава Содружества Наций.",
        "Американский предприниматель, изобретатель и промышленный дизайнер, получивший широкое признание в качестве пионера эры информационных технологий. Один из основателей, председатель совета директоров и CEO корпорации Apple. Один из основателей киностудии Pixar.",
        "Русский поэт, прозаик, драматург, художник. Творчество Лермонтова, в котором сочетаются гражданские, философские и личные мотивы, отвечавшие насущным потребностям духовной жизни русского общества, ознаменовало собой новый расцвет русской литературы и оказало большое влияние на виднейших русских писателей и поэтов XIX и XX веков. ",
        "Американская киноактриса, секс-символ 1950-х годов, певица и модель. Стала одним из наиболее культовых образов американского кинематографа и всей мировой культуры.",
        "Последний царь всея Руси и первый Император Всероссийский. Представитель династии Романовых. Был провозглашён царём в 10-летнем возрасте, стал править самостоятельно с 1689 года. Формальным соправителем Петра был его брат Иван.",
        "Русский поэт, драматург и прозаик, заложивший основы русского реалистического направления, литературный критик и теоретик литературы, историк, публицист, журналист; один из самых авторитетных литературных деятелей первой трети XIX века.",
        "Голландский художник, гравёр, крупнейший представитель золотого века голландской живописи. Он сумел воплотить в своих произведениях весь спектр человеческих переживаний с такой эмоциональной насыщенностью, которой до него не знало изобразительное искусство.",
        "Российский революционер, советский политический, государственный, военный и партийный деятель. Генеральный и первый секретарь ЦК ВКП"
    )

    private val Sex = arrayOf(
        "мужской",
        "мужской",
        "женский",
        "мужской",
        "мужской",
        "женский",
        "мужской",
        "мужской",
        "мужской",
        "мужской"
    )

    private val Photos = arrayOf(
        R.drawable.carrey,
        R.drawable.einshtein,
        R.drawable.elisabet2,
        R.drawable.jobs,
        R.drawable.lermontov,
        R.drawable.monroe,
        R.drawable.peter1,
        R.drawable.pushkin,
        R.drawable.rembrandtjpg,
        R.drawable.stalin
    )

    val persons: ArrayList<Persons> = ArrayList<Persons>()

    fun createCollectionPersons(): ArrayList<Persons>{
        for (i in 0..9){
            val person = Persons(
                id[i],
                Name[i],
                Years[i],
                Cuts[i],
                Sex[i],
                Photos[i]
            )
            persons.add(person)
        }
        return persons
    }

    fun getPersonsList(): ArrayList<Persons>{
        return persons
    }

    private var listeners = mutableListOf<activityListener>()

    fun addListener(listener: activityListener) {
        listeners.add(listener)
    }

    var curEl = 0
    class AsTask() : AsyncTask<Void,  Void, Void>() {
        private fun printTextInTextView(i: Int): ArrayList<Persons>{
            val person = Persons(
                id[i],
                Name[i],
                Years[i],
                Cuts[i],
                Sex[i],
                Photos[i]
            )
            persons.add(person)
            return persons
        }

        override fun onProgressUpdate(vararg values: Void?) {
            super.onProgressUpdate()
            printTextInTextView(curEl)
            curEl++
        }

        override fun doInBackground(vararg p0: Void?): Void? {
            for (i in 0..9) {
                TimeUnit.SECONDS.sleep(2)
                publishProgress()
            }
            return null
        }
    }
}
