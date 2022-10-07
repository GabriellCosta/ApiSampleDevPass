package dev.tigrao.devpass.domain.model

data class FetchMovieListModel(
    val data: List<FetchMovieListDataModel>
)

data class FetchMovieListDataModel(
    val image: String,
    val title: String,
    val author: String,
    val description: String,
    val schedule: ScheduleModel,
)

data class ScheduleModel(
    val time: String,
    val weekDay: List<String>,
)