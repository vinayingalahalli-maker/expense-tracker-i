from typing import Any, Optional, Union
from .utils.validator import Validator
from .utils.base_service import BaseService
from ..net.transport.serializer import Serializer
from ..net.sdk_config import SdkConfig
from ..net.environment.environment import Environment
from ..models.utils.sentinel import SENTINEL
from ..models.utils.cast_models import cast_models
from ..models import (
    CreateCategoryRequest,
    CreateClaimRequest,
    CreateExpenseRequest,
    RejectClaimRequest,
    UpdateExpenseRequest,
)


class ExpenseTrackerApiSdkService(BaseService):
    """
    Service class for ExpenseTrackerApiSdkService operations.
    Provides methods to interact with ExpenseTrackerApiSdkService-related API endpoints.
    Inherits common functionality from BaseService including authentication and request handling.
    """

    def __init__(self, *args, **kwargs):
        """Initialize the service and method-level configurations."""
        super().__init__(*args, **kwargs)
        self._list_categories_config: SdkConfig = {"environment": Environment.LOCALHOST}
        self._create_category_config: SdkConfig = {"environment": Environment.LOCALHOST}
        self._get_category_config: SdkConfig = {"environment": Environment.LOCALHOST}
        self._update_category_config: SdkConfig = {"environment": Environment.LOCALHOST}
        self._list_expenses_config: SdkConfig = {"environment": Environment.LOCALHOST}
        self._create_expense_config: SdkConfig = {"environment": Environment.LOCALHOST}
        self._get_expense_config: SdkConfig = {"environment": Environment.LOCALHOST}
        self._update_expense_config: SdkConfig = {"environment": Environment.LOCALHOST}
        self._delete_expense_config: SdkConfig = {"environment": Environment.LOCALHOST}
        self._list_claims_config: SdkConfig = {"environment": Environment.LOCALHOST}
        self._create_claim_config: SdkConfig = {"environment": Environment.LOCALHOST}
        self._get_claim_config: SdkConfig = {"environment": Environment.LOCALHOST}
        self._submit_claim_config: SdkConfig = {"environment": Environment.LOCALHOST}
        self._approve_claim_config: SdkConfig = {"environment": Environment.LOCALHOST}
        self._reject_claim_config: SdkConfig = {"environment": Environment.LOCALHOST}
        self._reimburse_claim_config: SdkConfig = {"environment": Environment.LOCALHOST}

    def set_list_categories_config(self, config: SdkConfig):
        """
        Sets method-level configuration for list_categories.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._list_categories_config = config
        return self

    def set_create_category_config(self, config: SdkConfig):
        """
        Sets method-level configuration for create_category.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._create_category_config = config
        return self

    def set_get_category_config(self, config: SdkConfig):
        """
        Sets method-level configuration for get_category.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._get_category_config = config
        return self

    def set_update_category_config(self, config: SdkConfig):
        """
        Sets method-level configuration for update_category.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._update_category_config = config
        return self

    def set_list_expenses_config(self, config: SdkConfig):
        """
        Sets method-level configuration for list_expenses.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._list_expenses_config = config
        return self

    def set_create_expense_config(self, config: SdkConfig):
        """
        Sets method-level configuration for create_expense.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._create_expense_config = config
        return self

    def set_get_expense_config(self, config: SdkConfig):
        """
        Sets method-level configuration for get_expense.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._get_expense_config = config
        return self

    def set_update_expense_config(self, config: SdkConfig):
        """
        Sets method-level configuration for update_expense.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._update_expense_config = config
        return self

    def set_delete_expense_config(self, config: SdkConfig):
        """
        Sets method-level configuration for delete_expense.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._delete_expense_config = config
        return self

    def set_list_claims_config(self, config: SdkConfig):
        """
        Sets method-level configuration for list_claims.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._list_claims_config = config
        return self

    def set_create_claim_config(self, config: SdkConfig):
        """
        Sets method-level configuration for create_claim.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._create_claim_config = config
        return self

    def set_get_claim_config(self, config: SdkConfig):
        """
        Sets method-level configuration for get_claim.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._get_claim_config = config
        return self

    def set_submit_claim_config(self, config: SdkConfig):
        """
        Sets method-level configuration for submit_claim.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._submit_claim_config = config
        return self

    def set_approve_claim_config(self, config: SdkConfig):
        """
        Sets method-level configuration for approve_claim.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._approve_claim_config = config
        return self

    def set_reject_claim_config(self, config: SdkConfig):
        """
        Sets method-level configuration for reject_claim.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._reject_claim_config = config
        return self

    def set_reimburse_claim_config(self, config: SdkConfig):
        """
        Sets method-level configuration for reimburse_claim.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._reimburse_claim_config = config
        return self

    @cast_models
    def list_categories(self, *, request_config: Optional[SdkConfig] = None) -> Any:
        """list_categories

        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        resolved_config = self._get_resolved_config(
            self._list_categories_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST.url or Environment.DEFAULT.url}/categories",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .serialize()
            .set_method("GET")
        )

        response, status, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def create_category(
        self,
        request_body: CreateCategoryRequest,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Any:
        """create_category

        :param request_body: The request body.
        :type request_body: CreateCategoryRequest
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(CreateCategoryRequest).is_nullable().validate(
            request_body, "request_body"
        )

        resolved_config = self._get_resolved_config(
            self._create_category_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST.url or Environment.DEFAULT.url}/categories",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .serialize()
            .set_method("POST")
            .set_body(request_body)
        )

        response, status, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def get_category(
        self, category_id: str, *, request_config: Optional[SdkConfig] = None
    ) -> Any:
        """get_category

        :param category_id: category_id
        :type category_id: str
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(str).validate(category_id, "category_id")

        resolved_config = self._get_resolved_config(
            self._get_category_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST.url or Environment.DEFAULT.url}/categories/{{category_id}}",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .add_path("category_id", category_id)
            .serialize()
            .set_method("GET")
        )

        response, status, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def update_category(
        self,
        request_body: CreateCategoryRequest,
        category_id: str,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Any:
        """update_category

        :param request_body: The request body.
        :type request_body: CreateCategoryRequest
        :param category_id: category_id
        :type category_id: str
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(CreateCategoryRequest).is_nullable().validate(
            request_body, "request_body"
        )
        Validator(str).validate(category_id, "category_id")

        resolved_config = self._get_resolved_config(
            self._update_category_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST.url or Environment.DEFAULT.url}/categories/{{category_id}}",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .add_path("category_id", category_id)
            .serialize()
            .set_method("PUT")
            .set_body(request_body)
        )

        response, status, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def list_expenses(
        self, status: str = SENTINEL, *, request_config: Optional[SdkConfig] = None
    ) -> Any:
        """list_expenses

        :param status: Filter by status: unclaimed | claimed, defaults to None
        :type status: str, optional
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(str).is_optional().validate(status, "status")

        resolved_config = self._get_resolved_config(
            self._list_expenses_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST.url or Environment.DEFAULT.url}/expenses",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .add_query("status", status, nullable=True)
            .serialize()
            .set_method("GET")
        )

        response, status, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def create_expense(
        self,
        request_body: CreateExpenseRequest,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Any:
        """create_expense

        :param request_body: The request body.
        :type request_body: CreateExpenseRequest
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(CreateExpenseRequest).is_nullable().validate(
            request_body, "request_body"
        )

        resolved_config = self._get_resolved_config(
            self._create_expense_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST.url or Environment.DEFAULT.url}/expenses",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .serialize()
            .set_method("POST")
            .set_body(request_body)
        )

        response, status, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def get_expense(
        self, expense_id: str, *, request_config: Optional[SdkConfig] = None
    ) -> Any:
        """get_expense

        :param expense_id: expense_id
        :type expense_id: str
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(str).validate(expense_id, "expense_id")

        resolved_config = self._get_resolved_config(
            self._get_expense_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST.url or Environment.DEFAULT.url}/expenses/{{expense_id}}",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .add_path("expense_id", expense_id)
            .serialize()
            .set_method("GET")
        )

        response, status, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def update_expense(
        self,
        request_body: UpdateExpenseRequest,
        expense_id: str,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Any:
        """update_expense

        :param request_body: The request body.
        :type request_body: UpdateExpenseRequest
        :param expense_id: expense_id
        :type expense_id: str
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(UpdateExpenseRequest).is_nullable().validate(
            request_body, "request_body"
        )
        Validator(str).validate(expense_id, "expense_id")

        resolved_config = self._get_resolved_config(
            self._update_expense_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST.url or Environment.DEFAULT.url}/expenses/{{expense_id}}",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .add_path("expense_id", expense_id)
            .serialize()
            .set_method("PUT")
            .set_body(request_body)
        )

        response, status, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def delete_expense(
        self, expense_id: str, *, request_config: Optional[SdkConfig] = None
    ) -> str:
        """delete_expense

        :param expense_id: expense_id
        :type expense_id: str
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: str
        """

        Validator(str).validate(expense_id, "expense_id")

        resolved_config = self._get_resolved_config(
            self._delete_expense_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST.url or Environment.DEFAULT.url}/expenses/{{expense_id}}",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .add_path("expense_id", expense_id)
            .serialize()
            .set_method("DELETE")
        )

        response, status, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def list_claims(
        self, status: str = SENTINEL, *, request_config: Optional[SdkConfig] = None
    ) -> Any:
        """list_claims

        :param status: Filter by status: draft | submitted | approved | rejected | reimbursed, defaults to None
        :type status: str, optional
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(str).is_optional().validate(status, "status")

        resolved_config = self._get_resolved_config(
            self._list_claims_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST.url or Environment.DEFAULT.url}/claims",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .add_query("status", status, nullable=True)
            .serialize()
            .set_method("GET")
        )

        response, _, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def create_claim(
        self,
        request_body: CreateClaimRequest,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Any:
        """create_claim

        :param request_body: The request body.
        :type request_body: CreateClaimRequest
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(CreateClaimRequest).is_nullable().validate(
            request_body, "request_body"
        )

        resolved_config = self._get_resolved_config(
            self._create_claim_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST.url or Environment.DEFAULT.url}/claims",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .serialize()
            .set_method("POST")
            .set_body(request_body)
        )

        response, status, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def get_claim(
        self, claim_id: str, *, request_config: Optional[SdkConfig] = None
    ) -> Any:
        """get_claim

        :param claim_id: claim_id
        :type claim_id: str
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(str).validate(claim_id, "claim_id")

        resolved_config = self._get_resolved_config(
            self._get_claim_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST.url or Environment.DEFAULT.url}/claims/{{claim_id}}",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .add_path("claim_id", claim_id)
            .serialize()
            .set_method("GET")
        )

        response, status, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def submit_claim(
        self, claim_id: str, *, request_config: Optional[SdkConfig] = None
    ) -> Any:
        """submit_claim

        :param claim_id: claim_id
        :type claim_id: str
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(str).validate(claim_id, "claim_id")

        resolved_config = self._get_resolved_config(
            self._submit_claim_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST.url or Environment.DEFAULT.url}/claims/{{claim_id}}/submit",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .add_path("claim_id", claim_id)
            .serialize()
            .set_method("POST")
        )

        response, _, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def approve_claim(
        self, claim_id: str, *, request_config: Optional[SdkConfig] = None
    ) -> Any:
        """approve_claim

        :param claim_id: claim_id
        :type claim_id: str
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(str).validate(claim_id, "claim_id")

        resolved_config = self._get_resolved_config(
            self._approve_claim_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST.url or Environment.DEFAULT.url}/claims/{{claim_id}}/approve",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .add_path("claim_id", claim_id)
            .serialize()
            .set_method("POST")
        )

        response, _, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def reject_claim(
        self,
        request_body: RejectClaimRequest,
        claim_id: str,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Any:
        """reject_claim

        :param request_body: The request body.
        :type request_body: RejectClaimRequest
        :param claim_id: claim_id
        :type claim_id: str
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(RejectClaimRequest).is_nullable().validate(
            request_body, "request_body"
        )
        Validator(str).validate(claim_id, "claim_id")

        resolved_config = self._get_resolved_config(
            self._reject_claim_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST.url or Environment.DEFAULT.url}/claims/{{claim_id}}/reject",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .add_path("claim_id", claim_id)
            .serialize()
            .set_method("POST")
            .set_body(request_body)
        )

        response, _, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def reimburse_claim(
        self, claim_id: str, *, request_config: Optional[SdkConfig] = None
    ) -> Any:
        """reimburse_claim

        :param claim_id: claim_id
        :type claim_id: str
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(str).validate(claim_id, "claim_id")

        resolved_config = self._get_resolved_config(
            self._reimburse_claim_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST.url or Environment.DEFAULT.url}/claims/{{claim_id}}/reimburse",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .add_path("claim_id", claim_id)
            .serialize()
            .set_method("POST")
        )

        response, _, _ = self.send_request(serialized_request)
        return response
