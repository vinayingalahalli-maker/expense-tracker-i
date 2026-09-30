import { z } from 'zod';

/**
 * Zod schema for the CreateExpenseRequest model.
 * Defines the structure and validation rules for this data type.
 * This is the shape used in application code - what developers interact with.
 */
export const createExpenseRequest = z.lazy(() => {
  return z.object({
    amount: z.number().optional().nullable(),
    currency: z.string().optional().nullable(),
    date: z.string().optional().nullable(),
    description: z.string().optional().nullable(),
    categoryId: z.string().optional().nullable(),
    additionalProperties: z.record(z.string(), z.unknown()).optional(),
  });
});

/**
 * @typedef {CreateExpenseRequest} createExpenseRequest
 * @property {number} amount
 * @property {string} currency
 * @property {string} date
 * @property {string} description
 * @property {string} categoryId
 */
export type CreateExpenseRequest = z.infer<typeof createExpenseRequest>;

/**
 * Zod schema for mapping API responses to the CreateExpenseRequest application shape.
 * Handles any property name transformations from the API schema.
 * If property names match the API schema exactly, this is identical to the application shape.
 */
export const createExpenseRequestResponse = z.lazy(() => {
  return z
    .object({
      amount: z.number().optional().nullable(),
      currency: z.string().optional().nullable(),
      date: z.string().optional().nullable(),
      description: z.string().optional().nullable(),
      category_id: z.string().optional().nullable(),
    })
    .passthrough()
    .transform((data) => {
      const additionalProperties: { [key: string]: unknown } = {};
      const declaredKeys = new Set<string>([
        'amount',
        'currency',
        'date',
        'description',
        'category_id',
      ]);
      for (const key of globalThis.Object.keys(data)) {
        if (!declaredKeys.has(key)) {
          additionalProperties[key] = (data as { [key: string]: unknown })[key];
        }
      }
      return {
        amount: data['amount'],
        currency: data['currency'],
        date: data['date'],
        description: data['description'],
        categoryId: data['category_id'],
        additionalProperties,
      };
    });
});

/**
 * Zod schema for mapping the CreateExpenseRequest application shape to API requests.
 * Handles any property name transformations required by the API schema.
 * If property names match the API schema exactly, this is identical to the application shape.
 */
export const createExpenseRequestRequest = z.lazy(() => {
  return z
    .object({
      amount: z.number().optional().nullable(),
      currency: z.string().optional().nullable(),
      date: z.string().optional().nullable(),
      description: z.string().optional().nullable(),
      categoryId: z.string().optional().nullable(),
      additionalProperties: z.record(z.string(), z.unknown()).optional(),
    })
    .transform((data) => ({
      ...(data['additionalProperties'] ?? {}),
      amount: data['amount'],
      currency: data['currency'],
      date: data['date'],
      description: data['description'],
      category_id: data['categoryId'],
    }));
});
