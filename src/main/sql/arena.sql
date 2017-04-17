select  count(*),c.name
    from cart c 
    inner join cart_deck cd
    on cd.id_cart=c.id_cart
    	inner join deck d
    	on d.id_deck=cd.id_deck
            inner join `client` cl
            on  cl.id_client=d.id_client
    where cl.id_arena=1
    group by c.name 
    order by count(*) desc
