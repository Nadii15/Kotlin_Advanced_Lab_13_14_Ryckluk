# Лабораторная работа №13-14
Коллекции, обобщения и функциональный стиль в Kotlin
## Описание
Данная лабораторная работа посвящена изучению продвинутых возможностей языкаKotlin,которые активно используются при разработке Android-приложений.
В рамках работы рассматриваются:
- обобщённые типы (Generics);
- коллекции Kotlin;
- функции высшего порядка;
- extension-функции;
  Все примеры ориентированы на практическое применение и подготовку к разработкемобильных приложений.
## Как запустить проект
1. Клонируйте репозиторий:
```bash
git clone <URL_репозитория>
```
## Автор
Рыхлюк Надежда Витальевна
## Лицензия
Проект создан в учебных целях.

# Лабораторная работа №13-14: Коллекции, обобщения и функциональный стиль в Kotlin

## Описание
Данная лабораторная работа посвящена изучению продвинутых возможностей языка Kotlin, которые активно используются при разработке современных приложений, включая Android-разработку.

## Изученные темы

### 1. Обобщённые типы (Generics)
Создание универсальных классов, работающих с разными типами данных без дублирования кода.

```kotlin
// Пример обобщённого класса вопроса
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

// Использование с разными типами ответов
val q1 = Question<String>("Столица Франции?", "Париж", Difficulty.EASY)
val q2 = Question<Boolean>("2 + 2 = 5?", false, Difficulty.MEDIUM)
val q3 = Question<Int>("Квадратный корень из 16?", 4, Difficulty.HARD)
```

### 2. Перечисления (enum class)
#### Ограничение допустимых значений для повышения типобезопасности.

```
enum class Difficulty {
EASY, MEDIUM, HARD
}
```

### 3. Data-классы
#### Автоматическая генерация методов equals(), hashCode(), toString(), copy().

```
data class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)
``` 
### 4. Singleton и объекты-компаньоны
 ####  Реализация паттерна одиночка для управления глобальным состоянием.

```
class Quiz {
    companion object StudentProgress {
        var answeredQuestions = 0
        var totalQuestions = 3
    }
}

// Доступ через имя класса
Quiz.answeredQuestions = 2
```

### 5. Extension-функции и свойства
####   Расширение функциональности существующих классов без наследования.

```
// Extension-свойство
val Quiz.StudentProgress.progressText: String
    get() = "$answeredQuestions из $totalQuestions"

// Extension-функция
fun Quiz.StudentProgress.printProgressBar() {
    repeat(answeredQuestions) { print(" ") }
    repeat(totalQuestions - answeredQuestions) { print(" ") }
    println("\n$progressText")
}
```
### 7. Коллекции Kotlin
#### Массивы (Array)
```
   val planets = arrayOf("Mercury", "Venus", "Earth")
   println(planets[0]) // Mercury
```
#### Списки (List / MutableList)
```
val solarSystem = mutableListOf("Mercury","Venus","Earth")
solarSystem.add("Mars") // Добавление в конец
solarSystem.add(3, "Asteroids") // Вставка по индексу
```
#### Множества (Set / MutableSet)
``` 
val uniquePlanets = mutableSetOf("Earth","Mars","Venus")
uniquePlanets.add("Earth") // Не добавится — дубликаты запрещены
```

#### Карты (Map / MutableMap)
```
val planetMoons = mutableMapOf(
    "Earth" to 1,
    "Mars" to 2,
    "Jupiter" to 79
)
println(planetMoons["Earth"]) // 1
```

#### 8. Функции высшего порядка
  ### Работа с функциями как с параметрами и возвращаемыми значениями.
```
// Функция как параметр
fun action(n1: Int, n2: Int, op: (Int, Int) -> Int) {
println(op(n1, n2))
}
action(5, 3, ::sum) // 8

// Возврат функции
fun selectAction(key: Int): (Int, Int) -> Int = when(key) {
1 -> ::sum
2 -> ::subtract
else -> ::multiply
}
```
#### 9. Функциональные операции над коллекциями
```
val cookies = listOf(cookie1, cookie2, cookie3)

// forEach — перебор элементов
cookies.forEach { println("${it.name}: $${it.price}") }

// map — преобразование
val names = cookies.map { it.name }

// filter — фильтрация
val softBaked = cookies.filter { it.softBaked }

// groupBy — группировка
val byType = cookies.groupBy { it.softBaked }

// fold — аккумуляция
val total = cookies.fold(0.0) { acc, cookie -> acc + cookie.price }

// sortedBy — сортировка
val sorted = cookies.sortedBy { it.price }
```
## Практическое применение
### Изученные концепции используются в реальных проектах для:
- Создания типобезопасных и переиспользуемых компонентов
- Упрощения работы с данными через функциональные операции
- Повышения читаемости и поддерживаемости кода
- Разработки эффективных алгоритмов обработки коллекций
- Построения архитектуры приложений (особенно в Android-разработке)
### Как запустить проект
1. Клонируйте репозиторий:
``` 
git clone <URL_репозитория>
```

2. Откройте проект в IntelliJ IDEA
3. Запустите файлы с функцией main() для просмотра примеров
## Автор
[Рыхлюк Надежда Витальевна]
## Лицензия
Проект создан в учебных целях.
