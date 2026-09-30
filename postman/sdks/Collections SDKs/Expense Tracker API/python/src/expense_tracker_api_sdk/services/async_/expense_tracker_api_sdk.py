from typing import Awaitable, Optional, Any, Union
from .utils.to_async import to_async
from ..expense_tracker_api_sdk import ExpenseTrackerApiSdkService
from ...net.sdk_config import SdkConfig
from ...models.utils.sentinel import SENTINEL
from ...models import (
    CreateCategoryRequest,
    CreateExpenseRequest,
    UpdateExpenseRequest,
    CreateClaimRequest,
    RejectClaimRequest,
)


class ExpenseTrackerApiSdkServiceAsync(ExpenseTrackerApiSdkService):
    """
    Async Wrapper for ExpenseTrackerApiSdkServiceAsync
    """

    def list_categories(
        self, *, request_config: Optional[SdkConfig] = None
    ) -> Awaitable[Any]:
        return to_async(super().list_categories)(request_config=request_config)

    def create_category(
        self,
        request_body: CreateCategoryRequest,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Awaitable[Any]:
        return to_async(super().create_category)(
            request_body, request_config=request_config
        )

    def get_category(
        self, category_id: str, *, request_config: Optional[SdkConfig] = None
    ) -> Awaitable[Any]:
        return to_async(super().get_category)(
            category_id, request_config=request_config
        )

    def update_category(
        self,
        request_body: CreateCategoryRequest,
        category_id: str,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Awaitable[Any]:
        return to_async(super().update_category)(
            request_body, category_id, request_config=request_config
        )

    def list_expenses(
        self, status: str = SENTINEL, *, request_config: Optional[SdkConfig] = None
    ) -> Awaitable[Any]:
        return to_async(super().list_expenses)(
            **{k: v for k, v in {"status": status}.items() if v is not SENTINEL},
            request_config=request_config,
        )

    def create_expense(
        self,
        request_body: CreateExpenseRequest,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Awaitable[Any]:
        return to_async(super().create_expense)(
            request_body, request_config=request_config
        )

    def get_expense(
        self, expense_id: str, *, request_config: Optional[SdkConfig] = None
    ) -> Awaitable[Any]:
        return to_async(super().get_expense)(expense_id, request_config=request_config)

    def update_expense(
        self,
        request_body: UpdateExpenseRequest,
        expense_id: str,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Awaitable[Any]:
        return to_async(super().update_expense)(
            request_body, expense_id, request_config=request_config
        )

    def delete_expense(
        self, expense_id: str, *, request_config: Optional[SdkConfig] = None
    ) -> Awaitable[str]:
        return to_async(super().delete_expense)(
            expense_id, request_config=request_config
        )

    def list_claims(
        self, status: str = SENTINEL, *, request_config: Optional[SdkConfig] = None
    ) -> Awaitable[Any]:
        return to_async(super().list_claims)(
            **{k: v for k, v in {"status": status}.items() if v is not SENTINEL},
            request_config=request_config,
        )

    def create_claim(
        self,
        request_body: CreateClaimRequest,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Awaitable[Any]:
        return to_async(super().create_claim)(
            request_body, request_config=request_config
        )

    def get_claim(
        self, claim_id: str, *, request_config: Optional[SdkConfig] = None
    ) -> Awaitable[Any]:
        return to_async(super().get_claim)(claim_id, request_config=request_config)

    def submit_claim(
        self, claim_id: str, *, request_config: Optional[SdkConfig] = None
    ) -> Awaitable[Any]:
        return to_async(super().submit_claim)(claim_id, request_config=request_config)

    def approve_claim(
        self, claim_id: str, *, request_config: Optional[SdkConfig] = None
    ) -> Awaitable[Any]:
        return to_async(super().approve_claim)(claim_id, request_config=request_config)

    def reject_claim(
        self,
        request_body: RejectClaimRequest,
        claim_id: str,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Awaitable[Any]:
        return to_async(super().reject_claim)(
            request_body, claim_id, request_config=request_config
        )

    def reimburse_claim(
        self, claim_id: str, *, request_config: Optional[SdkConfig] = None
    ) -> Awaitable[Any]:
        return to_async(super().reimburse_claim)(
            claim_id, request_config=request_config
        )
