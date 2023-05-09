const options = {
    year: 'numeric',
    month: 'long',
    day: 'numeric',
    hour: 'numeric',
    minute: 'numeric',
    second: 'numeric',
};

export const stringifyLocalDateTime = (datetime, locale) => {
    const date = new Date(datetime)
    return date.toLocaleDateString(locale, options);
}
