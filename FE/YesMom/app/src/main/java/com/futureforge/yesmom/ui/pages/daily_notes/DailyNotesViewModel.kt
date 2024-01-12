package com.futureforge.yesmom.ui.pages.daily_notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.futureforge.yesmom.common.UiState
import com.futureforge.yesmom.data.repo.YesMomRepository
import com.futureforge.yesmom.data.retrofit.response.LoginWithEmailResponse
import com.futureforge.yesmom.data.retrofit.response.PostNotesResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class DailyNotesViewModel(
    private val repository: YesMomRepository
) : ViewModel() {

    private val _notesState: MutableStateFlow<UiState<PostNotesResponse>> = MutableStateFlow(
        UiState.Loading
    )
    val notesState: StateFlow<UiState<PostNotesResponse>> get() = _notesState


    fun setNotesState(state: UiState<PostNotesResponse>) {
        _notesState.value = state
    }

    fun postNotes(text: String, emot_score: Int){
        viewModelScope.launch {
            repository.postNotesResponse(text, emot_score)
                .catch {
                    _notesState.value = UiState.Error("Cannot Post Data")
                }
                .collect{
                    _notesState.value = UiState.Success(it)

            }
        }

    }
}