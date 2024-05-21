package demoresult

@JvmInline
value class JobId(val id: Int)
data class Company(val name: String)
data class Job(val id: JobId, val company: Company, val salary: Double)

val jobs: Map<JobId, Job> = mapOf(
    JobId(1) to Job(JobId(1), Company("Apple, Inc."), 70_000.00),
    JobId(2) to Job(JobId(2), Company("Microsoft"), 80_000.00),
    JobId(3) to Job(JobId(3), Company("Google"), 90_000.00)
)

//fun findById(id: JobId): Job {
//    val job: Job? = jobs[id]
//    if (job != null) return job
//    else throw NoSuchElementException("Job not found")
//}

//fun retrieveSalary(id: JobId): Double {
//    val job: Job? = findById(id)
//    return try {
//        job.salary
//    } catch (e: Exception) {
//        0.0
//    }
//}

fun findById(id: JobId): Result<Job> {
    val job: Job? = jobs[id]
    return if (job != null) Result.success(job)
    else Result.failure(NoSuchElementException("Job not found"))
}

fun retrieveSalary(id: JobId): Result<Double> {
    val job: Result<Job> = findById(id)
    return job.map { it.salary }
}

fun main() {
    val jobId = 2
    val salary: Result<Double> = retrieveSalary(JobId(jobId))
    if (salary.isSuccess) {
        println("The salary of the job $jobId is ${salary.getOrNull()} $")
    } else {
        val ex = salary.exceptionOrNull()!!
        println(ex.javaClass.simpleName + ": " +ex.message)
    }

    //-----------------------------------------------------

    fun convertUsdToEur(amount: Double): Double =
        if (amount >= 75000.0) amount * 0.91
        else throw IllegalArgumentException("Amount too small")

    val salaryInEur: Result<Double> = salary.mapCatching { convertUsdToEur(it) }
    salaryInEur
        .onSuccess { println("The salary of the job $jobId is ${it} Euro") }
        .onFailure { println(it.javaClass.simpleName + ": " + it.message) }
    println()

    //-----------------------------------------------------

    fun String.toIntOrZero(): Int {
        val number = this.runCatching { this.toInt() }
        return number.getOrElse { 0 }
    }

    println("12.toIntOrZero() = ${"12".toIntOrZero()}")
    println("12a.toIntOrZero() = ${"12a".toIntOrZero()}")
}
