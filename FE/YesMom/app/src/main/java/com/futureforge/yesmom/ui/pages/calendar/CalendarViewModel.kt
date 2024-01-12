package com.futureforge.yesmom.ui.pages.calendar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.futureforge.yesmom.common.UiState
import com.futureforge.yesmom.data.repo.YesMomRepository
import com.futureforge.yesmom.data.retrofit.response.CalendarCreateResponse
import com.futureforge.yesmom.data.retrofit.response.LoginWithEmailResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CalendarViewModel(
    private val repository: YesMomRepository
) : ViewModel() {

    private val _calendarState: MutableStateFlow<UiState<CalendarCreateResponse>> = MutableStateFlow(
        UiState.Loading
    )
    val calendarState: StateFlow<UiState<CalendarCreateResponse>> get() = _calendarState

    fun setCalendarState(state: UiState<CalendarCreateResponse>) {
        _calendarState.value = state
    }


    fun scheduleCalendar(title: String, text: String, type: String, date: String){
        viewModelScope.launch {
            repository.calendarCreate(title,text, type, date )
                .catch {
                    _calendarState.value = UiState.Error("cannot post data")
                }
                .collect {
                    if(it.success!!) {
                        _calendarState.value = UiState.Success(it)
                    }else{
                        _calendarState.value = UiState.Error("cannot post data")
                    }

                }
        }

    }






}