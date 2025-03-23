# Issue with Dynamic Field Name in Hibernate @Filter

We're using hibernate reactive and trying to apply a Hibernate @Filter that compares two strings, where both the field
and value are passed as filter
parameters. However, it appears that Hibernate does not allow dynamic binding of field names via parameters

#### Test 1 & 2: We tried passing the field and value parameter

```sql
# binding parameter (1:VARCHAR) <- [lastname]
# binding parameter (2:VARCHAR) <- [Doe]

select u1_0.id,
       u1_0.lastname,
       u1_0.name
from users u1_0
where $1 = $2
```

#### Test 3: We were trying to pass multiple fields and values, but it looks like it's overridden by last pair

```sql
# binding parameter (1:VARCHAR) <- [lastname]
# binding parameter (2:VARCHAR) <- [Doe]

select u1_0.id,
       u1_0.lastname,
       u1_0.name
from users u1_0
where $1 = $2
```
---

Is this a limitation of Hibernate Reactive?
Is there something wrong with our setup, or does anyone know a workaround or fix for using dynamic field names in @Filter conditions?