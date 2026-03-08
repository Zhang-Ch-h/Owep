function bsSuggest(object,url,fieldName){
    $(object).bsSuggest({
        url: url,
        showBtn: true,
        getDataMethod: "firstByUrl",
        idField: "id",
        keyField: fieldName,
        effectiveFields: [fieldName],
        searchFields:[fieldName]
    })
}
function bsSuggestNoShow(object,url,fieldName){
    $(object).bsSuggest({
        url: url,
        showBtn: false,
        getDataMethod: "url",
        idField: "id",
        keyField: fieldName,
        effectiveFields: [fieldName],
        searchFields:[fieldName]
    })
}