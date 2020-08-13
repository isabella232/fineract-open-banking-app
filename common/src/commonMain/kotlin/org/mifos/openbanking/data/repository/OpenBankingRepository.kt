package org.mifos.openbanking.data.repository

import org.mifos.openbanking.base.Response
import org.mifos.openbanking.data.datasources.network.NetworkDataSource
import org.mifos.openbanking.domain.usecase.createClient.CreateClientRequest
import org.mifos.openbanking.domain.usecase.createClient.CreateClientResponse
import org.mifos.openbanking.domain.usecase.fetchAccounts.FetchAccountsRequest
import org.mifos.openbanking.domain.usecase.fetchAccounts.FetchAccountsResponse
import org.mifos.openbanking.domain.usecase.fetchBalances.FetchBalancesRequest
import org.mifos.openbanking.domain.usecase.fetchBalances.FetchBalancesResponse
import org.mifos.openbanking.domain.usecase.fetchBanks.FetchBanksRequest
import org.mifos.openbanking.domain.usecase.fetchBanks.FetchBanksResponse
import org.mifos.openbanking.domain.usecase.loginClient.LoginClientRequest
import org.mifos.openbanking.domain.usecase.loginClient.LoginClientResponse
import org.mifos.openbanking.domain.usecase.createTransactionRequest.CreateTransactionRequestRequest
import org.mifos.openbanking.domain.usecase.createTransactionRequest.CreateTransactionRequestResponse

class OpenBankingRepository(
    private val networkDataSource: NetworkDataSource
) {

    suspend fun createClient(request: CreateClientRequest): Response<CreateClientResponse> {
        return networkDataSource.getClientApi()
            .createClient(request.name, request.contact, request.scopes, request.redirectUris);
    }

    suspend fun loginClient(request: LoginClientRequest): Response<LoginClientResponse> {
        return networkDataSource.getClientApi().loginClient(request);
    }

    suspend fun fetchAccounts(request: FetchAccountsRequest): Response<FetchAccountsResponse> {
        return networkDataSource.getClientApi().fetchAccounts(request)
    }

    suspend fun fetchBalances(request: FetchBalancesRequest): Response<FetchBalancesResponse> {
        return networkDataSource.getClientApi().fetchBalances(request)
    }

    suspend fun fetchBanks(request: FetchBanksRequest): Response<FetchBanksResponse> {
        return networkDataSource.getBankApi().fetchBanks(request)
    }

    suspend fun createTransactionRequest(request: CreateTransactionRequestRequest): Response<CreateTransactionRequestResponse> {
        return networkDataSource.getClientApi().createTransactionRequest(request)
    }


}
