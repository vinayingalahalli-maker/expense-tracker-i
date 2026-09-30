from __future__ import annotations
from pydantic import Field
from typing import Optional
from typing import Any
from typing import Union
from .utils.base_model import BaseModel


class UpdateExpenseRequest(BaseModel):
    """UpdateExpenseRequest

    :param amount: amount, defaults to None
    :type amount: int, optional
    :param currency: currency, defaults to None
    :type currency: str, optional
    :param date_: date_, defaults to None
    :type date_: str, optional
    :param description: description, defaults to None
    :type description: str, optional
    :param category_id: category_id, defaults to None
    :type category_id: str, optional
    """

    amount: Optional[int] = Field(default=None)
    currency: Optional[str] = Field(default=None)
    date_: Optional[str] = Field(alias="date", serialization_alias="date", default=None)
    description: Optional[str] = Field(default=None)
    category_id: Optional[str] = Field(default=None)

    def model_dump_original(self, **kwargs):
        result = super().model_dump_original(**kwargs)
        extra_fields = self.model_extra or {}
        return {**extra_fields, **result}
