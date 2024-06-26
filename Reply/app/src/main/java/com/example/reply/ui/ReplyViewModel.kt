package com.example.reply.ui

import androidx.lifecycle.ViewModel
import com.example.reply.data.Email
import com.example.reply.data.MailboxType
import com.example.reply.data.local.LocalEmailsDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ReplyViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(ReplyUiState())
    val uiState: StateFlow<ReplyUiState> = _uiState

    init {
        initializeUiState()
    }

    private fun initializeUiState() {
        val mailboxes: Map<MailboxType, List<Email>> =
            LocalEmailsDataProvider.allEmail.groupBy { it.mailbox }
        _uiState.value = ReplyUiState(
            mailboxes = mailboxes,
            currentSelectedEmail = mailboxes[MailboxType.Inbox]?.get(0) ?: LocalEmailsDataProvider.defaultEmail
        )
    }

    fun updateDetailsScreenStates(email: Email) {
        _uiState.update {
            it.copy(
                currentSelectedEmail = email,
                isShowingHomePage = false
            )
        }
    }

    fun resetHomeScreenStates() {
        _uiState.update {
            it.copy(
                currentSelectedEmail = it.mailboxes[it.currentMailbox]?.get(0) ?: LocalEmailsDataProvider.defaultEmail,
                isShowingHomePage = true
            )
        }
    }

    fun updateCurrentMailbox(mailboxType: MailboxType) {
        _uiState.update {
            it.copy(
                currentMailbox = mailboxType
            )
        }
    }
}